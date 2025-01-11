package com.example.lostandfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;
import com.example.lostandfound.service.AdminService;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5000")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // Get all items
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return adminService.getAllItems();
    }

    // Get all return requests for approval
    @GetMapping("/approveReturn")
    public List<Item> getPendingReturns() {
        return adminService.getPendingReturns();
    }

    // Approve a return and update merit points
    @PostMapping("/approveReturn")
    public ResponseEntity<String> approveItemReturn(@RequestParam Integer itemId, @RequestParam Integer userId) {
        try {
            adminService.approveItemReturn(itemId, userId);
            return ResponseEntity.ok("Item return approved, merit points updated.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // Delete a user
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        try {
            adminService.deleteUser(userId);
            return ResponseEntity.ok("User with ID " + userId + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    // Delete an item
    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer itemId) {
        try {
            adminService.deleteItem(itemId);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // Approve an item
    @PostMapping("/approveItem/{itemId}")
    public ResponseEntity<String> approveItem(@RequestParam Integer itemId) {
        try {
            adminService.approveItem(itemId);
            return ResponseEntity.ok("Item approved successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // Award merit points
    @PostMapping("/meritPoints/{itemId}/{userId}")
    public ResponseEntity<String> giveMeritPoints(@RequestParam Integer itemId, @RequestParam Integer userId) {
        try {
            adminService.giveMeritPoints(itemId, userId);
            return ResponseEntity.ok("Merit points awarded successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
