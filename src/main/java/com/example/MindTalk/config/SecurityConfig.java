package com.example.MindTalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (enable it in production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/register-client").permitAll() // Allow unauthenticated access to the registration endpoint
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                );

        return http.build();
    }
}