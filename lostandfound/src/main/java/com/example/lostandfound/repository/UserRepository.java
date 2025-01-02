package com.example.lostandfound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Find user by email (used for authentication or user verification)
    User findByEmail(String email);

    Optional<User> findByName(String username);

    // Find user by ID with a custom query
    @Override
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(@Param("id") Integer id);

    // Find all users by role (e.g., Admin, Student)
    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") String role);

    // Search users by name (case-insensitive and partial match)
    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> searchByName(@Param("name") String name);

    // Find users by merit point range
    @Query("SELECT u FROM User u WHERE u.meritPoints BETWEEN :minPoints AND :maxPoints")
    List<User> findByMeritPointsBetween(@Param("minPoints") Integer minPoints, @Param("maxPoints") Integer maxPoints);

    // Check if a user exists by email
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
