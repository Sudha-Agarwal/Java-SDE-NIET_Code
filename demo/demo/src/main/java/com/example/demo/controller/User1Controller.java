package com.example.demo.controller;

import com.example.demo.model.Users;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*@RestController
@RequestMapping("/users1")
public class User1Controller {
    private Map<Integer, Users> users = new HashMap<>();


    //Rest APIs
    @GetMapping
    public ResponseEntity<Map<Integer,Users>> getAllUsers(){
        users.put(1,new Users("Sudha"));
        //System.out.println(users.get(1));
        //return users;
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getuserById(@PathVariable int id){
        System.out.println("Path variable: " + id);
        if(users.containsKey(id)){
            return ResponseEntity.ok(users.get(id));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            //return new ResponseEntity<>("user nt found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> createUser(@RequestBody Users user){
        //Print request body
        System.out.println("Request body: " + user.getName());
        int id = users.size() + 1;
        users.put(id, user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("user created with id: " +id);
    }

    //PUT - Update user
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Users user){
        if(users.containsKey(id)){
            users.put(id, user);
            return ResponseEntity.ok("user updated");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam int id){
        if(users.containsKey(id)){
            return ResponseEntity.ok(users.get(id));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }






}
*/