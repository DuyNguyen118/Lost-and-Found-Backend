package com.example.lostandfound.service.impl;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;
import com.example.lostandfound.repository.AdminActionRepository;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.repository.UserRepository;
import com.example.lostandfound.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final AdminActionRepository adminActionRepository;

    @Autowired
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
    public void approveItemReturn(Long itemId, Long userId) {
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
        action.setAdminId((int) 1L); // Replace with the actual admin's ID in real use
        action.setActionType("Approve Return");
        action.setActionDate(new Date());
        action.setDetails("Approved return for Item ID: " + itemId + " by User ID: " + userId);
        logAdminAction(action);
    }

    @Override
    public AdminAction logAdminAction(AdminAction action) {
        return adminActionRepository.save(action);
    }
}

