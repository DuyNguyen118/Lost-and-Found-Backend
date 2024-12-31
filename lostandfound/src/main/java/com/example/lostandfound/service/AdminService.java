package com.example.lostandfound.service;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;
import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    List<Item> getAllItems();
    void approveItemReturn(Long itemId, Long userId);
    AdminAction logAdminAction(AdminAction action);
}
