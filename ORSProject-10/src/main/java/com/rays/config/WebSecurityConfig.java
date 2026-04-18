package com.rays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig configures Spring Security for the application.
 * 
 * It defines:
 * - URL access rules (public and secured endpoints)
 * - Stateless session management (JWT आधारित authentication)
 * - Integration of JWTRequestFilter in the security filter chain
 * - CORS and CSRF configurations
 * 
 * @author Lucky Tomar
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	/**
	 * Configures HTTP security settings.
	 * 
	 * - Disables CSRF (since JWT is used)
	 * - Allows unauthenticated access to specific endpoints
	 * - Secures all other endpoints
	 * - Sets session management to stateless
	 * - Adds JWT filter before UsernamePasswordAuthenticationFilter
	 * 
	 * @param http HttpSecurity object
	 * @throws Exception in case of configuration errors
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/Auth/**", "/User/profilePic/**").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
	}
}