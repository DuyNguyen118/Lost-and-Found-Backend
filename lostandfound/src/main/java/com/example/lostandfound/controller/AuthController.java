package com.example.lostandfound.controller;

import com.example.lostandfound.dto.AuthResponse;
import com.example.lostandfound.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lostandfound.model.User;
import com.example.lostandfound.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5000")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.validateUserLogin(loginRequest.getUsername(), loginRequest.getPassword());
            AuthResponse response = new AuthResponse(
                "dummy-token", // Replace with generated JWT token if applicable
                user.getRole(),
                user.getName(),
                "Login successful"
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse(null, null, null, e.getMessage()));
        }
    }
}
