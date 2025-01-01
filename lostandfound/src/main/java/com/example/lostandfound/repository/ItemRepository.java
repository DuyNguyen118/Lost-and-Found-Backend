package com.example.lostandfound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Location;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Existing queries
    List<Item> findByCategory(String category);
    
    List<Item> findByStatus(String status);

    @Query("SELECT i FROM Item i WHERE i.categories IN :categories")
    List<Item> findByCategories(@Param("categories") List<String> categories);

    @Query("SELECT i FROM Item i WHERE i.status IN :statuses")
    List<Item> findByStatuses(@Param("statuses") List<String> statuses);

    @Query("SELECT i FROM Item i WHERE i.itemId = :id")
    Optional<Item> findById(@Param("id") Integer id);

    // New queries for enhanced functionality
    @Query("SELECT i FROM Item i WHERE LOWER(i.itemName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(i.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Item> searchItems(@Param("keyword") String keyword);

<<<<<<< Updated upstream
    @Query("SELECT i FROM Item i WHERE i.room = :room")
    List<Item> findByRoom(@Param("room") String room);

    @Query("SELECT i FROM Item i WHERE i.contactInfo = :contactInfo")
    List<Item> findByContactInfo(@Param("contactInfo") String contactInfo);

    @Query("SELECT i FROM Item i WHERE i.location = :location")
    List<Item> findByLocation(@Param("location") Location location);
    // Additional custom queries can be added here
}
=======
    @Query("SELECT i FROM Item i WHERE i.block = :location")
    List<Item> findByLocation(@Param("location") String location);

    @Query("SELECT i FROM Item i WHERE i.reportedBy = :userId")
    List<Item> findByReportedBy(@Param("userId") Integer userId);

    // Modified to use itemId instead of id to match the entity field
    @Query("DELETE FROM Item i WHERE i.itemId = :id")
    void deleteById(@Param("id") Integer id);
}
>>>>>>> Stashed changes
