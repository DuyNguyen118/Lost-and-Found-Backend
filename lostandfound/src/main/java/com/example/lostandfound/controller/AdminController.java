package com.example.lostandfound.controller;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.User;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
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

    // Review and approve an item return
    @PostMapping("/approveReturn")
    public String approveItemReturn(@RequestParam Long itemId, @RequestParam Long userId) {
        adminService.approveItemReturn(itemId, userId);
        return "Item return approved, merit points updated.";
    }

    // Log an admin action
    @PostMapping("/logAction")
    public AdminAction logAdminAction(@RequestBody AdminAction action) {
        return adminService.logAdminAction(action);
    }
}
