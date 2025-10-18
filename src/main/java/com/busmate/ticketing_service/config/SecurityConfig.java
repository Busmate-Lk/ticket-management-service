package com.busmate.ticketing_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CorsConfigurationSource corsConfigurationSource;

    public SecurityConfig(CorsConfigurationSource corsConfigurationSource) {
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Enable CORS with our custom configuration
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                
                // Disable CSRF for stateless API
                .csrf(csrf -> csrf.disable())
                
                // Stateless session management
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                
                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Allow access to API endpoints, Swagger docs, and actuator
                        .requestMatchers(
                            "/api/**",
                            "/v3/api-docs/**", 
                            "/swagger-ui/**", 
                            "/swagger-ui.html",
                            "/actuator/**"
                        ).permitAll()
                        
                        // All other requests require authentication
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
