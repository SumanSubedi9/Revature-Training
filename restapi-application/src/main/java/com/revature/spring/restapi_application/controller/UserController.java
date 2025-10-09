package com.revature.spring.restapi_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spring.restapi_application.models.User;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class UserController {

    // Creating a Fake Database
    private List<User> users = new ArrayList<>();

    // Create a new user
    public UserController() {
        users.add(new User(1L, "John Doe", "john.doe@example.com"));
        users.add(new User(2L, "Jane Smith", "jane.smith@example.com"));
    }

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return users;
    }

    // Get user by ID
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add a new user
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        user.setId((long) (users.size() + 1)); // Simple ID assignment
        users.add(user);
        return user;
    }

}
