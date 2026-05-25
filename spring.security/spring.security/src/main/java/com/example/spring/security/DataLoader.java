package com.example.spring.security;

import com.example.spring.security.entity.AppUser;
import com.example.spring.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository repository,
                      PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        /*
         * Encode password before storing
         */
        String hashedPassword =
                passwordEncoder.encode("1234");

        AppUser user = new AppUser(
                "Sudha",
                hashedPassword,
                "USER"
        );
        repository.save(user);

        AppUser admin = new AppUser(
                "admin",
                passwordEncoder.encode("admin123"),
                "ADMIN"
        );

        repository.save(admin);

        System.out.println("Users saved in database");
    }
}
