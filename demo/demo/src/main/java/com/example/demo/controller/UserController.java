package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    //create User
    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users user){
        Users created = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    //Get All Users
    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(service.getAllUsers());
    }
    //Get by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Users user = service.getUserById(id);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }

    //Find By name (Derived Query)
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Users>> getByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Users>> getByNameAndEmail(
            @RequestParam String name,
            @RequestParam String email
    ){
        return ResponseEntity.ok(service.findByNameAndEmail(name,email));
    }

    @GetMapping("/search-or")
    public ResponseEntity<List<Users>> getByNameOrEmail(
            @RequestParam String name,
            @RequestParam String email
    ){
        return ResponseEntity.ok(service.findByNameOrEmail(name,email));
    }

    @DeleteMapping("/email")
    public ResponseEntity<String> deleteByEmail(@RequestParam String email){
        service.deleteByEmail(email);
        return ResponseEntity.ok("Deleted User with email: " + email);

    }

    @GetMapping("/jpql/{name}")
    public ResponseEntity<List<Users>> getByNameJPQL(@PathVariable String name){
        return ResponseEntity.ok(service.getByNameJPQL(name));
    }

    @GetMapping("/native/{name}")
    public ResponseEntity<List<Users>> nativeQuery(@PathVariable String name){
        return ResponseEntity.ok(service.findByNameNative(name));

    }




}