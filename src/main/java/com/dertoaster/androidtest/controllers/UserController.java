package com.dertoaster.androidtest.controllers;

import com.dertoaster.androidtest.models.Role;
import com.dertoaster.androidtest.models.User;
import com.dertoaster.androidtest.repositories.RoleRepository;
import com.dertoaster.androidtest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(2L));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Saved";
    }

    @GetMapping("/testAdmin")
    public String adminTest() {
        return "you are an Admin";
    }
    @GetMapping("/testUser")
    public String adminUser() {
        return "you are a User";
    }

    @GetMapping("/test")
    public String test() {
        return "you are a permittet";
    }


}
