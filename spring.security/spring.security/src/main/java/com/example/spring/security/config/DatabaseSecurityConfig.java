package com.example.spring.security.config;

import com.example.spring.security.entity.AppUser;
import com.example.spring.security.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DatabaseSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Load user from Database
    @Bean
    public UserDetailsService userDetailsService(UserRepository repository){
        return username -> {
            AppUser appUser = repository.findByUsername(username)
                    .orElseThrow(()->new RuntimeException("User not found"));

            //Convert DB user into Spring Security User
            UserDetails user = User.builder()
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole())
                    .build();
            return user;

        };
    }

    //Security Rules
  /*  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //start configuration HttpSecurity

        http.csrf(csrf-> csrf.disable())
                //Allow H2 console frame
                .headers(headers-> headers.frameOptions(frame->frame.disable()))
                .authorizeHttpRequests(auth->auth.requestMatchers("/public").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()) //every request needs login
                .httpBasic(Customizer.withDefaults()); //enables basic authentication

        return http.build();

    }

   */

    //For authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //start configuration HttpSecurity

        http.csrf(csrf-> csrf.disable())
                //Allow H2 console frame
                .headers(headers-> headers.frameOptions(frame->frame.disable()))
                .authorizeHttpRequests(auth->auth.requestMatchers("/public").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        //USER Role Only
                        .requestMatchers("/user/**").hasRole("USER")
                        //Adimin Role Only
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()) //every request needs login
                .httpBasic(Customizer.withDefaults()); //enables basic authentication

        return http.build();

    }


}
