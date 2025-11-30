package com.example.tecnologias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.EntityGraph;
import com.example.tecnologias.persistence.model.Project;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByProjectNameContainingIgnoreCase(String word);
    
    @Override
    List<Project> findAll();

}