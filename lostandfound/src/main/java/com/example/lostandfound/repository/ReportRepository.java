package com.example.lostandfound.repository;

import com.example.lostandfound.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // Additional custom queries can be added here
}
