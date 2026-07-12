package com.example.oauth2_jwt_thymeleaf.config;

import com.example.oauth2_jwt_thymeleaf.oauth.OAuth2SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final OAuth2SuccessHandler successHandler;

    //Dependency Injection
    public SecurityConfig(OAuth2SuccessHandler successHandler){
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth->auth.requestMatchers("/","/login")
                .permitAll()
                .anyRequest()
                .authenticated())
                .oauth2Login(oauth-> oauth.loginPage("/login")
                        .successHandler(successHandler));

        return http.build();
    }
}
