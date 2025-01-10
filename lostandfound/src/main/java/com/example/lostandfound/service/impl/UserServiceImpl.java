package com.example.lostandfound.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.lostandfound.dto.RegisterRequest;
import com.example.lostandfound.model.User;
import com.example.lostandfound.repository.UserRepository;
import com.example.lostandfound.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest request) {
        // Create a new User object from RegisterRequest
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // In production, remember to hash the password
        user.setStudentId(request.getStudentId());
        user.setRole("USER"); // Default role
        user.setMeritPoints(0); // Default merit points

        // Save the user to the database
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Integer id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new RuntimeException("User not found with id: " + id);
            }
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Cannot delete user due to existing references. Please delete associated records first.", e);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage(), e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User validateUserLogin(String username, String password) {
    return userRepository.findByName(username)
            .filter(user -> user.getPassword().equals(password))
            .orElseThrow(() -> new RuntimeException("Invalid username or password"));
}
}
