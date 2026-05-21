package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(
            RoleService service) {

        this.service = service;
    }

    // CREATE ROLE
    @PostMapping
    public ResponseEntity<Role> create(
            @RequestBody Role role) {

        Role created =
                service.createRole(role);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    // GET ALL ROLES
    @GetMapping
    public ResponseEntity<List<Role>> getAll() {

        return ResponseEntity.ok(
                service.getAllRoles());
    }

    // GET ROLE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Long id) {

        Role role =
                service.getRoleById(id);

        if (role != null) {
            return ResponseEntity.ok(role);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Role not found");
    }

    // UPDATE ROLE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Role role) {

        Role updated =
                service.updateRole(
                        id,
                        role);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Role not found");
    }

    // DELETE ROLE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.deleteRole(id);

        return ResponseEntity.ok(
                "Role deleted");
    }
}