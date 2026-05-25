package com.example.spring.security.repository;

import com.example.spring.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    //derived query method name
    Optional<AppUser> findByUsername(String username);
}
