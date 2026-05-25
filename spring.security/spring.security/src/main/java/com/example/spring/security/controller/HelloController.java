package com.example.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/public")
    public String publicApi(){
        return "This is public API";
    }

    @GetMapping("/private")
    public String privateApi(){
        return "This is secured API";
    }

    @GetMapping("/user")
    public String userApi(){
        return "User API";
    }

    @GetMapping("/admin")
    public String adminApi(){
        return "Admin API";
    }
}
