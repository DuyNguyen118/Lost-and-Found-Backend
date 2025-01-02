package com.example.lostandfound.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;

    @ManyToOne
    @JoinColumn(name = "sender", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver", nullable = false)
    private User receiver;


    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private boolean isSystemMessage;

    // Constructors
    public Chat() {
        this.timestamp = LocalDateTime.now(); // Default timestamp
        this.isSystemMessage = false;        // Default value
    }

    public Chat(User sender, User receiver, String content, boolean isSystemMessage) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now(); // Automatically set timestamp
        this.isSystemMessage = isSystemMessage;
    }

    // Getters and Setters
    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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
    public int hashCode() {
        return Objects.hash(chatId, sender, receiver, content, timestamp, isSystemMessage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chat chat = (Chat) obj;
        return isSystemMessage == chat.isSystemMessage &&
               Objects.equals(chatId, chat.chatId) &&
               Objects.equals(sender, chat.sender) &&
               Objects.equals(receiver, chat.receiver) &&
               Objects.equals(content, chat.content) &&
               Objects.equals(timestamp, chat.timestamp);
    }

    @Override
    public String toString() {
        return "Chat{" +
               "chatId=" + chatId +
               ", senderId=" + (sender != null ? sender.getName() : null) +
               ", receiverId=" + (receiver != null ? receiver.getName() : null) +
               ", content='" + content + '\'' +
               ", timestamp=" + timestamp +
               ", isSystemMessage=" + isSystemMessage +
               '}';
    }
}
