package com.example.lostandfound.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Chat {
    private Long chatId;           
    private Long senderId;         
    private Long receiverId;       
    private String content;        
    private LocalDateTime timestamp; 
    private boolean isSystemMessage; 

    // Constructors
    public Chat() {
    }

    public Chat(Long chatId, Long senderId, Long receiverId, String content, LocalDateTime timestamp, boolean isSystemMessage) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
        this.isSystemMessage = isSystemMessage;
    }

    // Getters and Setters
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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
        return Objects.hash(chatId, senderId, receiverId, content, timestamp, isSystemMessage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chat chat = (Chat) obj;
        return isSystemMessage == chat.isSystemMessage &&
               Objects.equals(chatId, chat.chatId) &&
               Objects.equals(senderId, chat.senderId) &&
               Objects.equals(receiverId, chat.receiverId) &&
               Objects.equals(content, chat.content) &&
               Objects.equals(timestamp, chat.timestamp);
    }

    @Override
    public String toString() {
        return "Chat{" +
               "chatId=" + chatId +
               ", senderId=" + senderId +
               ", receiverId=" + receiverId +
               ", content='" + content + '\'' +
               ", timestamp=" + timestamp +
               ", isSystemMessage=" + isSystemMessage +
               '}';
    }
}
