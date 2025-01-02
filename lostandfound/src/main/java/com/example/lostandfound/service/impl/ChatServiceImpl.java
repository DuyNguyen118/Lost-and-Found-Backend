package com.example.lostandfound.service.impl;

import com.example.lostandfound.model.Chat;
import com.example.lostandfound.model.User;
import com.example.lostandfound.repository.ChatRepository;
import com.example.lostandfound.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat sendMessage(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getMessagesBetweenUsers(User sender, User receiver) {
        return chatRepository.findChatsBetweenUsers(sender, receiver);  // Use the correct repository method
    }
}
