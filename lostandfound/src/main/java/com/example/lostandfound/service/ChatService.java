package com.example.lostandfound.service;

import com.example.lostandfound.model.User;
import com.example.lostandfound.model.Chat;
import java.util.List;

public interface ChatService {
    Chat sendMessage(Chat chat);
    List<Chat> getMessagesBetweenUsers(User sender, User receiver);
}
