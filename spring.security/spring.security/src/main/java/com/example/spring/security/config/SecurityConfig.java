package com.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Marks this class as configuration class
//spring scans and loads it automatically
/*@Configuration
public class SecurityConfig {
    @Bean
    //InMemoryUserDetailsManager stores user object temporarily in memory
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails user = User.builder()
                .username("Sudha")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    //Hashes passwords securely
    public PasswordEncoder passwordEncoder(){
        //Bcrypt is used for hashing password
        return new BCryptPasswordEncoder();
    }

    //SecurityFilterChain defines security rules
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //start configuration HttpSecurity

        http.csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/public").permitAll()
                        .anyRequest().authenticated()) //every request needs login
                .httpBasic(Customizer.withDefaults()); //enables basic authentication

        return http.build();

    }


}*/
