package com.example.lostandfound.repository;

import com.example.lostandfound.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findChatsBetweenUsers(Long senderId, Long receiverId);
}
