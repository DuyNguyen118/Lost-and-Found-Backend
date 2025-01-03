package com.example.lostandfound.controller;

import com.example.lostandfound.dto.AuthResponse;
import com.example.lostandfound.dto.LoginRequest;
import com.example.lostandfound.dto.RegisterRequest;

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

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            // Register the user using the service method
            User user = userService.registerUser(registerRequest);
            
            // Create a response (you can generate a token here if needed)
            AuthResponse response = new AuthResponse(
                "dummy-token", // Replace with a real token generation logic
                user.getRole(),
                user.getName(),
                "Registration successful"
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);  // HTTP 201 for successful creation
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse(null, null, null, e.getMessage()));
        }
    }
}
