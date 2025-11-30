package com.example.tecnologias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.EntityGraph;
import com.example.tecnologias.persistence.model.Project;
import java.util.List;

// Interfaz que me permite heredar métodos JPA (findAll, findByid, save...).
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByProjectNameContainingIgnoreCase(String word); // Este método lo implemento porqie
                                                                // al ser un método que no se hereda de JPA
                                                                // porque es personalizado, lo tengo que xrear yo
    
    @Override
    List<Project> findAll();

}