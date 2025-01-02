package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    // Find all chats for a specific user
    @Query("SELECT c FROM Chat c WHERE c.user.userId = :userId ORDER BY c.timestamp ASC")
    List<Chat> findChatsByUser(@Param("userId") int userId);

    // Find all system-generated messages for a user
    @Query("SELECT c FROM Chat c WHERE c.user.userId = :userId AND c.isSystemMessage = true ORDER BY c.timestamp ASC")
    List<Chat> findSystemMessagesByUser(@Param("userId") int userId);

    // Find all user-generated messages
    @Query("SELECT c FROM Chat c WHERE c.user.userId = :userId AND c.isSystemMessage = false ORDER BY c.timestamp ASC")
    List<Chat> findUserMessages(@Param("userId") int userId);
}
