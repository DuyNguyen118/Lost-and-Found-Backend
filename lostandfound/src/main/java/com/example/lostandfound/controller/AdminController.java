package com.example.lostandfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    //private UserService userService;
    //private ItemService itemService;

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
    public String approveItemReturn(@RequestParam Integer itemId, @RequestParam Integer userId) {
        adminService.approveItemReturn(itemId, userId);
        return "Item return approved, merit points updated.";
    }

    // Delete a user
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@RequestParam Integer userId) {
        adminService.deleteUser(userId);
        return "User deleted successfully";
    }

    // Delete an item
    @DeleteMapping("/items/{itemId}")
    public String deleteItem(@RequestParam Integer itemId) {
        adminService.deleteItem(itemId);
        return "Item deleted successfully";
    }

    // Approve an item
    @PostMapping("/approveItem")
    public String approveItem(@RequestParam Integer itemId) {
        adminService.approveItem(itemId);
        return "Item approved successfully";
    }

    // Award merit points
    @PostMapping("/meritPoints")
    public String giveMeritPoints(@RequestParam Integer itemId, @RequestParam Integer userId) {
        adminService.giveMeritPoints(itemId, userId);
        return "Merit points awarded successfully";
    }

    // Log an admin action
    @PostMapping("/logAction")
    public AdminAction logAdminAction(@RequestBody AdminAction action) {
        return adminService.logAdminAction(action);
    }
}
