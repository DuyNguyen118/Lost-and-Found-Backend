package com.example.lostandfound.service;

import java.util.List;

import com.example.lostandfound.model.Chat;

public interface ChatService {
    // Save a chat message (either user-generated or system-generated)
    Chat sendMessage(Chat chat);

    // Retrieve all messages (both user and system) for a specific user
    List<Chat> getMessagesByUser(int userId);

    // Retrieve system-generated messages for a user
    List<Chat> getSystemMessages(int userId);

    // Retrieve user-generated messages for a user
    List<Chat> getUserMessages(int userId);
}
