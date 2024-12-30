package com.example.lostandfound.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String name;
    private String password;
    private String email;
    private String studentId;
    private String role;
    private int meritPoints;

    @Column(name = "date_joined")
    private Timestamp dateJoined;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    // Constructor
    public User() {
        this.dateJoined = new Timestamp(System.currentTimeMillis());
        this.lastLogin = new Timestamp(System.currentTimeMillis());
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getRole() {
        return role;
    }

    public int getMeritPoints() {
        return meritPoints;
    }

    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMeritPoints(int meritPoints) {
        this.meritPoints = meritPoints;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
}