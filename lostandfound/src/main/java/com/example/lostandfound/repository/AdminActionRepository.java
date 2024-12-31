package com.example.lostandfound.repository;

import com.example.lostandfound.model.AdminAction;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminActionRepository extends JpaRepository<AdminAction, Integer> {

    // Find actions taken by a specific admin
    List<AdminAction> findByAdminId(Long adminId);

    // Find actions by type
    @Query("SELECT a FROM AdminAction a WHERE a.actionType = :type")
    List<AdminAction> findActionsByType(@Param("type") String type);

    // Find actions within a specific date range
    @Query("SELECT a FROM AdminAction a WHERE a.actionDate BETWEEN :startDate AND :endDate")
    List<AdminAction> findActionsInDateRange(@Param("startDate") LocalDate startDate, 
                                             @Param("endDate") LocalDate endDate);
    
    // Find all merit-point-related actions
    @Query("SELECT a FROM AdminAction a WHERE a.actionType = 'MERIT_POINT_ADJUSTMENT'")
    List<AdminAction> findAllMeritPointAdjustments();
}
