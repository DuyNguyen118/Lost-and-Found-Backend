package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    // Find chats between two specific users
    @Query("SELECT c FROM Chat c WHERE (c.senderId = :userId1 AND c.receiverId = :userId2) " +
           "OR (c.senderId = :userId2 AND c.receiverId = :userId1) ORDER BY c.timestamp ASC")
    List<Chat> findChatsBetweenUsers(@Param("userId1") Long senderId, @Param("userId2") Long receiverId);

    // Find all chats sent or received by a user
    @Query("SELECT c FROM Chat c WHERE c.senderId = :userId OR c.receiverId = :userId ORDER BY c.timestamp DESC")
    List<Chat> findChatsByUser(@Param("userId") Long userId);

    // Search for chat messages containing a specific keyword
    @Query("SELECT c FROM Chat c WHERE LOWER(c.content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Chat> searchChats(@Param("keyword") String keyword);

    // Get the latest chat between two users
    @Query("SELECT c FROM Chat c WHERE (c.senderId = :userId1 AND c.receiverId = :userId2) " +
           "OR (c.senderId = :userId2 AND c.receiverId = :userId1) ORDER BY c.timestamp DESC")
    List<Chat> findLatestChatBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);
}
