package com.example.demo.repository;

import com.example.demo.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository <Auto,Integer> {
}
