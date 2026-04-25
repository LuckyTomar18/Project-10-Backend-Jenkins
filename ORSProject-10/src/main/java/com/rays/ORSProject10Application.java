package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class for ORS Project 10 Spring Boot Application.
 * This class is responsible for bootstrapping the application
 * and configuring global settings like CORS.
 * 
 * @author Lucky Tomar
 */
@SpringBootApplication
public class ORSProject10Application {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ORSProject10Application.class, args);
    }

    /**
     * Bean configuration for enabling and customizing CORS (Cross-Origin Resource Sharing).
     * This allows frontend applications (like Angular) to communicate with backend APIs.
     * 
     * @return WebMvcConfigurer instance with CORS mappings
     */
    @Bean
    public WebMvcConfigurer corsConfig() {

        WebMvcConfigurer w = new WebMvcConfigurer() {

            /**
             * Configure CORS mappings for the application.
             * 
             * @param registry CorsRegistry to register mappings
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                CorsRegistration cors = registry.addMapping("/**") 
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
            
			/*
			 * @Override public void addInterceptors(InterceptorRegistry registry) {
			 * registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns(
			 * "/Auth/**"); } };
			 */
        };

        return w;
    }
}