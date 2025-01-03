package com.example.lostandfound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Category;
import com.example.lostandfound.model.enums.Location;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCategory(String category);
    
    List<Item> findByStatus(String status);

    List<Item> findByLocation(Location location);

    @Query("SELECT i FROM Item i WHERE i.category IN :category")
    List<Item> findByCategory(@Param("category") List<String> category);

    @Query("SELECT i FROM Item i WHERE i.status IN :statuses")
    List<Item> findByStatuses(@Param("statuses") List<String> statuses);

    @Override
    @Query("SELECT i FROM Item i WHERE i.itemId = :id")
    Optional<Item> findById(@Param("id") Integer id);

    @Query("SELECT i FROM Item i WHERE i.status = :status AND i.itemId = :itemId")
    Optional<Item> findByStatusAndId(@Param("status") String status, @Param("itemId") int itemId);

    @Query("SELECT i FROM Item i WHERE LOWER(i.itemName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
           "OR LOWER(i.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Item> searchItems(@Param("keyword") String keyword);

    @Query("SELECT i FROM Item i WHERE i.location = :location")
    List<Item> findByLocation(@Param("location") String location);

    @Query("SELECT i FROM Item i WHERE i.reportedBy = :userId")
    List<Item> findByReportedBy(@Param("userId") Integer userId);

    @Override
    @Query("DELETE FROM Item i WHERE i.itemId = :id")
    void deleteById(@Param("id") Integer id);

    @Query("SELECT i FROM Item i WHERE i.status = :status AND i.category = :category AND i.location = :location AND i.id <> :itemId")
    List<Item> findPotentialMatches(@Param("status") String status, 
                                    @Param("category") String category, 
                                    @Param("location") String location, 
                                    @Param("itemId") Long itemId);

    @Query("SELECT i FROM Item i WHERE i.category = :category")                     
    List<Item> findItemsByCategory(Category category);

}