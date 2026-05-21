package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository){
        this.repository = repository;
    }

    //Create
    public Role createRole(Role role){
        return repository.save(role);
    }
    // GET ALL
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    // GET BY ID
    public Role getRoleById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    // UPDATE
    public Role updateRole(
            Long id,
            Role role) {

        Role existing =
                repository.findById(id)
                        .orElse(null);

        if (existing != null) {

            existing.setRoleName(
                    role.getRoleName());

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void deleteRole(Long id) {
        repository.deleteById(id);
    }
}
