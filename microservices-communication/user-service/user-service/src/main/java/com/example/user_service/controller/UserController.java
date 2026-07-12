package com.example.user_service.controller;

import com.example.user_service.dto.OrderDTO;
import com.example.user_service.dto.UserResponseDTO;
import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestClient restClient;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow();
        OrderDTO[] orders = restClient.get()
                .uri("Http://localhost:8082/orders/user/" + id)
                .retrieve()
                .body(OrderDTO[].class);
        return new UserResponseDTO(user.getId(),user.getName(),user.getEmail(), Arrays.asList(orders));

    }
}
