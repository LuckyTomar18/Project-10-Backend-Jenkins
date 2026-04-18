package com.rays.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Front Controller Interceptor for handling request pre-processing.
 * It manages CORS configuration and session validation.
 * 
 * @author Lucky Tomar
 *
 */
@Component
public class FrontCtl extends HandlerInterceptorAdapter {

	/**
	 * Intercepts incoming requests before reaching controller.
	 * Handles CORS headers and session validation.
	 * 
	 * @param request HttpServletRequest object
	 * @param response HttpServletResponse object
	 * @param handler Handler object
	 * @return true if request should proceed, false otherwise
	 * @throws Exception if any error occurs
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Set CORS headers
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		// Handle preflight request
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			return false;
		}

		HttpSession session = request.getSession();

		// Validate session
		if ((UserContext) session.getAttribute("userContext") == null) {
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter out = response.getWriter();
			out.print("{\"success\":\"false\",\"error\":\"OOPS! Your session has been expired\"}");
			out.close();
			return false;
		}
		return true;
	}
}