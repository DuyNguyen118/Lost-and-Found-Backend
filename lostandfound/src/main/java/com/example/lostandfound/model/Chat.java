package com.example.lostandfound.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;  // User associated with this chat

    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private boolean isSystemMessage;  // True if the message is from the system

    // Constructors
    public Chat() {
        this.timestamp = LocalDateTime.now();
    }

    public Chat(User user, String content, boolean isSystemMessage) {
        this.user = user;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.isSystemMessage = isSystemMessage;
    }

    // Getters and Setters
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSystemMessage() {
        return isSystemMessage;
    }

    public void setSystemMessage(boolean systemMessage) {
        isSystemMessage = systemMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return chatId == chat.chatId && isSystemMessage == chat.isSystemMessage &&
               Objects.equals(user, chat.user) &&
               Objects.equals(content, chat.content) &&
               Objects.equals(timestamp, chat.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, user, content, timestamp, isSystemMessage);
    }

    @Override
    public String toString() {
        return "Chat{" +
               "chatId=" + chatId +
               ", user=" + (user != null ? user.getName() : "null") +
               ", content='" + content + '\'' +
               ", timestamp=" + timestamp +
               ", isSystemMessage=" + isSystemMessage +
               '}';
    }
}
