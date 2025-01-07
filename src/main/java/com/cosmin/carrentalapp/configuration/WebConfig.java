package com.cosmin.carrentalapp.configuration;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:5173") // Allow requests from the frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies/authentication headers
            }
        };
    }
}
