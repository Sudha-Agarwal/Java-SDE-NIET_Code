package com.example.security.jwt.config;

import com.example.security.jwt.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    //constructor injection

    public SecurityConfig(JwtFilter jwtFilter){
        this.jwtFilter = jwtFilter;
    }

    //Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(
            //main security configuration object
            HttpSecurity http) throws Exception{
               //disable CSRF
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers(
                        "/login",
                        "/home",
                        "/auth/login",
                        "/js/**"
                ).permitAll()
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll())
                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }


}
