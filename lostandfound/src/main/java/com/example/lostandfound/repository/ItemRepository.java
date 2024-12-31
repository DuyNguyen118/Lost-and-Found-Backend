package com.example.lostandfound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCategory(String category);
    
    List<Item> findByStatus(String status);

    @Query("SELECT i FROM Item i WHERE i.category IN :categories")
    List<Item> findByCategories(@Param("categories") List<String> categories);

    @Query("SELECT i FROM Item i WHERE i.status IN :statuses")
    List<Item> findByStatuses(@Param("statuses") List<String> statuses);

    // Additional custom queries can be added here
}
