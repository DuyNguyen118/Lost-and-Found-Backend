package com.example.lostandfound.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true, nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private int meritPoints;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chat> sentChats = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chat> receivedChats = new ArrayList<>();

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMeritPoints() {
        return meritPoints;
    }

    public void setMeritPoints(int meritPoints) {
        this.meritPoints = meritPoints;
    }

    public List<Chat> getSentChats() {
        return sentChats;
    }

    public void setSentChats(List<Chat> sentChats) {
        this.sentChats = sentChats;
    }

    public List<Chat> getReceivedChats() {
        return receivedChats;
    }

    public void setReceivedChats(List<Chat> receivedChats) {
        this.receivedChats = receivedChats;
    }

    // Override methods for equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
               meritPoints == user.meritPoints &&
               Objects.equals(name, user.name) &&
               Objects.equals(password, user.password) &&
               Objects.equals(email, user.email) &&
               Objects.equals(studentId, user.studentId) &&
               Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password, email, studentId, role, meritPoints);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                ", role='" + role + '\'' +
                ", meritPoints=" + meritPoints +
                '}';
    }
}
