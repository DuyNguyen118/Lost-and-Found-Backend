package com.example.lostandfound.service;

import java.util.List;
import com.example.lostandfound.model.User;

public interface UserService {
    User registerUser(User user);
    User getUserById(Integer id);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
    List<User> getAllUsers();
    User validateUserLogin(String username, String password); // New method
}
