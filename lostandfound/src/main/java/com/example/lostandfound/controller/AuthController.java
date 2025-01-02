package com.example.lostandfound.controller;

import com.example.lostandfound.dto.LoginRequest;
import com.example.lostandfound.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5000")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Add your authentication logic here
            // For now, returning a simple response
            AuthResponse response = new AuthResponse(
                "dummy-token",
                "USER",
                loginRequest.getUsername(),
                "Login successful"
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new AuthResponse(null, null, null, "Login failed"));
        }
    }
}
