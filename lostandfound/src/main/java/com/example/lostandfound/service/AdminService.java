package com.example.lostandfound.service;

import java.util.List;

import com.example.lostandfound.model.AdminAction;
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.User;

public interface AdminService {
    public List<User> getAllUsers();
    public List<Item> getAllItems();
    public void approveItemReturn(Integer itemId, Integer userId);
    public void deleteItem(Integer itemId);
    public AdminAction logAdminAction(AdminAction action);
    public void approveItem(Integer itemId);
    public void giveMeritPoints(Integer itemId, Integer userId);
    public void deleteUser(Integer userId);
    public List<Item> getPendingReturns();

}
