package com.example.lostandfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;
import com.example.lostandfound.service.AdminService;

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
    public String approveItemReturn(@RequestParam Integer itemId, @RequestParam Integer userId) {
        adminService.approveItemReturn(itemId, userId);
        return "Item return approved, merit points updated.";
    }

    // Log an admin action
    @PostMapping("/logAction")
    public AdminAction logAdminAction(@RequestBody AdminAction action) {
        return adminService.logAdminAction(action);
    }
}
