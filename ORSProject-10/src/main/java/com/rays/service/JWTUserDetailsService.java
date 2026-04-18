package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rays.dto.UserDTO;

/**
 * JWTUserDetailsService is used to load user details from database
 * for authentication in Spring Security.
 * 
 * It implements UserDetailsService and overrides loadUserByUsername()
 * to fetch user by loginId.
 * 
 * @author Lucky Tomar
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

	/**
	 * Password encoder bean using BCrypt algorithm
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserServiceInt userService;

	/**
	 * Loads user from database using username (loginId)
	 * and converts it into Spring Security UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO user = userService.findByLoginId(username, null);

		if (user == null) {
			System.out.println("user found nuulllll");
			throw new UsernameNotFoundException("User not found with username : " + username);
		}

		return User.builder().username(user.getLoginId()).password(passwordEncoder().encode(user.getPassword()))
				.roles("USER").build();
	}
}