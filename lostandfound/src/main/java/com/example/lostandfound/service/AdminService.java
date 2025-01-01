package com.example.lostandfound.service;

import java.util.List;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;

public interface AdminService {
    List<User> getAllUsers();
    List<Item> getAllItems();
    void approveItemReturn(Long itemId, Integer userId);
    AdminAction logAdminAction(AdminAction action);
}
