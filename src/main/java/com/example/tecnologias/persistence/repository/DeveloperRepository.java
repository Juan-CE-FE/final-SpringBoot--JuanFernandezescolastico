package com.example.tecnologias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tecnologias.persistence.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    
}