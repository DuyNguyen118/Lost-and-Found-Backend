package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    // Find reports by type (e.g., "Lost", "Found")
    @Query("SELECT r FROM Report r WHERE r.reportType = :reportType")
    List<Report> findByReportType(@Param("reportType") String reportType);

    // Find reports by a specific item ID
    @Query("SELECT r FROM Report r WHERE r.itemId = :itemId")
    List<Report> findByItemId(@Param("itemId") Long itemId);

    // Find reports submitted by a specific user ID
    @Query("SELECT r FROM Report r WHERE r.userId = :userId")
    List<Report> findByUserId(@Param("userId") Long userId);

    // Search for reports by description content (case-insensitive)
    //@Query("SELECT r FROM Report r WHERE LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    //List<Report> searchByDescription(@Param("keyword") String keyword);

    // Get all reports within a specific date range
    @Query("SELECT r FROM Report r WHERE r.reportDate BETWEEN :startDate AND :endDate")
    List<Report> findReportsByDateRange(@Param("startDate") java.util.Date startDate,
                                        @Param("endDate") java.util.Date endDate);

    // Get reports that match both item and user
    @Query("SELECT r FROM Report r WHERE r.itemId = :itemId AND r.userId = :userId")
    List<Report> findReportsByItemAndUser(@Param("itemId") Long itemId, @Param("userId") Long userId);
}
