package com.example.lostandfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lostandfound.model.AdminAction;

@Repository
public interface AdminActionRepository extends JpaRepository<AdminAction, Integer> {

}
