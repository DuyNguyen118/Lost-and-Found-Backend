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
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCategory(String category);
    
    List<Item> findByStatus(String status);

    @Query("SELECT i FROM Item i WHERE i.category IN :categories")
    List<Item> findByCategories(@Param("categories") List<String> categories);

    @Query("SELECT i FROM Item i WHERE i.status IN :statuses")
    List<Item> findByStatuses(@Param("statuses") List<String> statuses);

     @Query("SELECT i FROM Item i WHERE i.id = :id")
    Optional<Item> findById(@Param("id") Long id);

    @Query("DELETE FROM Item i WHERE i.id = :id")
    void deleteById(@Param("id") Long id);

    @Query("SELECT i FROM Item i WHERE i.room = :room")
    List<Item> findByRoom(@Param("room") String room);

    @Query("SELECT i FROM Item i WHERE i.contactInfo = :contactInfo")
    List<Item> findByContactInfo(@Param("contactInfo") String contactInfo);

    @Query("SELECT i FROM Item i WHERE i.location = :location")
    List<Item> findByLocation(@Param("location") Location location);
    // Additional custom queries can be added here
}
