package com.rays.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;
import com.rays.service.UserServiceInt;

/**
 * JWTRequestFilter is responsible for intercepting incoming HTTP requests
 * and validating JWT tokens.
 * 
 * It extracts the token from the Authorization header, validates it,
 * and sets authentication in Spring Security context.
 * 
 * It also loads user details from database and sets UserContext
 * in ThreadLocal for use throughout the request lifecycle.
 * 
 * Additionally, it handles database connection failures and invalid tokens.
 * 
 * @author Lucky Tomar
 *
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private UserServiceInt userService;

	/**
	 * This method is executed once per request.
	 * It processes JWT token validation and authentication setup.
	 * 
	 * @param request HTTP request
	 * @param response HTTP response
	 * @param filterChain filter chain
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		System.out.println("JWT Token ======>>>>> " + authorizationHeader);

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			System.out.println("JWT Token ======>>>>> iiiiinnnnnn");

			String jwtToken = authorizationHeader.substring(7);

			try {

				String loginId = jwtUtil.extractLoginId(jwtToken);

				if (!jwtUtil.validateToken(jwtToken, loginId)) {
					throw new Exception("Invalid JWT token");
				}

				if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(loginId);

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}

				UserDTO dto = new UserDTO();
				dto.setLoginId(loginId);

				System.out.println("request filter: " + dto.getLoginId());

				// Fetch full user from DB to get complete details (like userId)
				UserContext tempContext = new UserContext(dto);
				UserDTO fullUserDTO = userService.findByLoginId(loginId, tempContext);

				if (fullUserDTO != null) {
				    UserContext context = new UserContext(fullUserDTO);
				    UserContextHolder.setContext(context);
				} else {
				    UserContext context = new UserContext(dto);
				    UserContextHolder.setContext(context);
				}

			}catch(CannotCreateTransactionException | DataAccessResourceFailureException | JDBCConnectionException e) {
				 // Database is down
                response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); // 503
                response.setContentType("application/json");
                response.getWriter().write("{\"result\":{\"message\":\"Database server down!! Please try again later.\"},\"success\":false}");
                return;
			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Token is invalid... plz login again..!!");
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
}