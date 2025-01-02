package com.example.lostandfound.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lostandfound.model.Chat;
import com.example.lostandfound.repository.ChatRepository;
import com.example.lostandfound.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    // Save a chat message
    @Override
    public Chat sendMessage(Chat chat) {
        // Automatically set the timestamp and system message flag if needed
        chat.setTimestamp(chat.getTimestamp() != null ? chat.getTimestamp() : java.time.LocalDateTime.now());
        return chatRepository.save(chat);
    }

    // Retrieve all chats for a user
    @Override
    public List<Chat> getMessagesByUser(int userId) {
        return chatRepository.findChatsByUser(userId);
    }

    // Retrieve only system-generated messages
    @Override
    public List<Chat> getSystemMessages(int userId) {
        return chatRepository.findSystemMessagesByUser(userId);
    }

    // Retrieve only user-generated messages
    @Override
    public List<Chat> getUserMessages(int userId) {
        return chatRepository.findUserMessages(userId);
    }
}
