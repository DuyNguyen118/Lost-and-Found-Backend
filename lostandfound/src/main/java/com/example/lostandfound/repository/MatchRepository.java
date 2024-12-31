package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Match;
import com.example.lostandfound.model.Report;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    // Find all reports for a specific item
    List<Report> findByItemId(Long itemId);

    // Find reports by report type
    List<Report> findByReportType(String reportType);

    // Find reports created by a specific user
    @Query("SELECT r FROM Report r WHERE r.userId = :userId")
    List<Report> findReportsByUser(@Param("userId") Long userId);

    // Additional custom queries can be added here
    }
