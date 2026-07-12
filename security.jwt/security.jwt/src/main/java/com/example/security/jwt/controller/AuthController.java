package com.example.security.jwt.controller;

import com.example.security.jwt.security.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    public AuthController(JwtService jwtService){
        this.jwtService = jwtService;
    }
    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username,
            @RequestParam String password
    ){
        System.out.println(username);
        System.out.println(password);
        if(username.equals("admin") && password.equals("1234")){
            String token = jwtService.generateToken(username);
            System.out.println(token);
            Map<String, String> response = new HashMap<>();
            response.put("token",token);
            return response;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
