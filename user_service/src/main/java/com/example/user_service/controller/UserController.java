package com.example.user_service.controller;
import com.example.user_service.dto.UserRequest;
import com.example.user_service.dto.UserResponse;
import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        // Convert UserRequest to a User entity, create the user, and return a UserResponse
        User user = userService.createUser(userRequest);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    @GetMapping("/{username}")
    public UserResponse getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }

    @GetMapping("/byEmail/{email}")
    public UserResponse getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
