package com.example.user_service.dto;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<OrderDTO> order;


    public UserResponseDTO(){}

    public UserResponseDTO(Long id, String name, String email, List<OrderDTO> order) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDTO> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDTO> order) {
        this.order = order;
    }
}
