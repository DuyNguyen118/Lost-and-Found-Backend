package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    // Find all matches involving a specific lost item
    @Query("SELECT m FROM Match m WHERE m.lostItemId = :lostItemId")
    List<Match> findByLostItemId(@Param("lostItemId") Long lostItemId);

    // Find all matches involving a specific found item
    @Query("SELECT m FROM Match m WHERE m.foundItemId = :foundItemId")
    List<Match> findByFoundItemId(@Param("foundItemId") Long foundItemId);

    // Find matches by date range
    @Query("SELECT m FROM Match m WHERE m.matchDate BETWEEN :startDate AND :endDate")
    List<Match> findMatchesByDateRange(@Param("startDate") java.util.Date startDate,
                                       @Param("endDate") java.util.Date endDate);

    // Find matches by category similarity
    @Query("SELECT m FROM Match m WHERE m.lostItem.category = :category OR m.foundItem.category = :category")
    List<Match> findByCategory(@Param("category") String category);

    // Custom query for suggesting matches based on location
    @Query("SELECT m FROM Match m WHERE m.lostItem.location = m.foundItem.location AND m.lostItemId <> m.foundItemId")
    List<Match> findMatchesByLocation();
}
