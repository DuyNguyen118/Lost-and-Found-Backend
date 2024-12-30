package com.example.lostandfound.model;

import java.util.Objects;

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
    private int userId;

    private String name;

    private String password;

    private String email;

    @Column(unique = true)
    private String studentId;

    private String role;

    private int meritPoints;

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
}
