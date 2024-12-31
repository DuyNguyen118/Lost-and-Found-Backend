package com.example.lostandfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    // Additional custom queries can be added here
}
