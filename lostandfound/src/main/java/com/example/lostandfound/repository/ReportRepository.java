package com.example.lostandfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    // Additional custom queries can be added here
}
