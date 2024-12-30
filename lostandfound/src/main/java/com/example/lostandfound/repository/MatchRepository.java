package com.example.lostandfound.repository;

import com.example.lostandfound.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional custom queries can be added here
}
