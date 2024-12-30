package com.example.lostandfound.service;

import com.example.lostandfound.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
