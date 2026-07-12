package com.example.order_service.controller;

import com.example.order_service.entity.OrderEntity;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public OrderEntity addOrder(@RequestBody OrderEntity order){
        return orderRepository.save(order);
    }

    @GetMapping("/user/{userId}")
    public List<OrderEntity> getOrderByUser(@PathVariable Long userId){
        return orderRepository.findByUserId(userId);
    }

}
