package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.Users;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Users createUser(Users user){
        //Handle One-to-One: Link profile to User
        if(user.getProfile()!=null){
            user.getProfile().setUser(user);
        }
        //Handle One-to-Many : Link each post to User
        if(user.getPosts()!=null){
            user.getPosts().forEach(post-> post.setUser(user));
        }
        //Handle Many-to-Many
        Set<Role> managedRoles = new HashSet<>();

        for(Role role : user.getRoles()) {

            Role dbRole = roleRepository
                    .findById(role.getId())
                    .orElseThrow(() ->
                            new RuntimeException("Role not found"));

            managedRoles.add(dbRole);
        }
        user.setRoles(managedRoles);
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {

        Users user =
                userRepository.findById(id)
                        .orElse(null);

        if (user != null) {

            // MANY TO MANY
            user.getRoles().clear();

            userRepository.delete(user);
        }
    }
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    //Derived Query Methods
    public List<Users> findByName(String name){
        return userRepository.findByName(name);
    }

    public List<Users> findByNameAndEmail(String name,String email){
        return userRepository.findByNameAndEmail(name,email);
    }


    public List<Users> findByNameOrEmail(String name,String email){
        return userRepository.findByNameOrEmail(name,email);
    }
@Transactional
    public void deleteByEmail(String email){
        userRepository.deleteByEmail(email);
    }

    //JPQL
    public List<Users> getByNameJPQL(String name){
        return userRepository.getByNameJPQL(name);
    }

    //Native Query
    public List<Users> findByNameNative(String name){
        return userRepository.findByNameNative(name);
    }


}
