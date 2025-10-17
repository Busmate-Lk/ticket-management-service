package com.busmate.ticketing_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Allow all origins — you can restrict to your frontend domain later
        config.setAllowedOriginPatterns(List.of("*"));

        // ✅ Allow common methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Allow common headers
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept", "Origin"));

        // ✅ Allow credentials if using cookies or tokens
        config.setAllowCredentials(true);

        // ✅ Expose headers if frontend needs them
        config.setExposedHeaders(List.of("Authorization", "Content-Disposition"));

        // Register config for all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
