package com.example.oauth2_jwt_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/dashboard")
    public String dashboard(String token,String email, Model model){
        model.addAttribute("token",token);
        model.addAttribute("email",email);
        return "dashboard";




    }
}
