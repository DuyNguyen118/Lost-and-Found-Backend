package com.example.lostandfound.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;
import com.example.lostandfound.repository.AdminActionRepository;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.repository.UserRepository;
import com.example.lostandfound.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final AdminActionRepository adminActionRepository;

    public AdminServiceImpl(UserRepository userRepository, 
                            ItemRepository itemRepository, 
                            AdminActionRepository adminActionRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.adminActionRepository = adminActionRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    @Override
    public List<Item> getPendingReturns() {
        return itemRepository.findByStatus("Pending Return"); // Assuming pending items have a status of "Pending Return"
    }

    @Override
    public void approveItemReturn(Integer itemId, Integer userId) {
        // Fetch the item
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

        // Fetch the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Update item status to "Returned"
        item.setStatus("Returned");
        itemRepository.save(item);

        // Update user merit points
        user.setMeritPoints(user.getMeritPoints() + 10); // Example merit point increment
        userRepository.save(user);

        // Log admin action
        AdminAction action = new AdminAction();
        action.setAdminId(1); // Replace with actual admin's ID
        action.setActionType("Approve Return");
        action.setActionDate(new Date());
        action.setDetails("Approved return for Item ID: " + itemId + " by User ID: " + userId);
        logAdminAction(action);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        System.out.println("User found: " + user);
        userRepository.delete(user);
    }
    
    @Override
    public void deleteItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
        System.out.println("Item found: " + item);
        itemRepository.delete(item);
    }

    @Override
    public void approveItem(Integer itemId) {
        // Fetch the item and approve it
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

        item.setStatus("Approved");
        itemRepository.save(item);

    }

    @Override
    public void giveMeritPoints(Integer itemId, Integer userId) {
        // Fetch the item and user
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
                System.out.println("Item found: " + item);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
                System.out.println("User found: " + user);
        // Award merit points
        user.setMeritPoints(user.getMeritPoints() + 5); // Example merit point increment
        userRepository.save(user);

    }

    @Override
    public AdminAction logAdminAction(AdminAction action) {
        return adminActionRepository.save(action);
    }
}