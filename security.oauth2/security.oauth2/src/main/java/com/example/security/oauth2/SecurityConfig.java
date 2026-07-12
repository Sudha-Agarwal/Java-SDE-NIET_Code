package com.example.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    private final OAuth2SuccessHandler successHandler;
    public SecurityConfig(OAuth2SuccessHandler successHandler){
        this.successHandler  = successHandler;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
        http.authorizeHttpRequests(auth->auth
                                .requestMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                )
                .oauth2Login(Customizer.withDefaults());
                //.oauth2Login(oauth->oauth.successHandler(successHandler));
        return http.build();
    }
}
