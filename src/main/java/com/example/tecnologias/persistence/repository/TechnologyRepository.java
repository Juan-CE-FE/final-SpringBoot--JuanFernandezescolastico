package com.example.tecnologias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tecnologias.persistence.model.Technology;

// Interfaz que me permite heredar métodos JPA (findAll, findByid, save...).
@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}