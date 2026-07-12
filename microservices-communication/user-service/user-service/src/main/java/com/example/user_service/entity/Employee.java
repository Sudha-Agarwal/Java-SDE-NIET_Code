package com.example.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    private double salary;
}


