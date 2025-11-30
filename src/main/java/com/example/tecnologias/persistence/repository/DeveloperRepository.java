package com.example.tecnologias.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tecnologias.persistence.model.Developer;

// Interfaz que me permite heredar métodos JPA (findAll, findByid, save...).
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> { // le paso la entidad que
                                                                        // va a manejar esta interfaz
                                                                        // y el tipo de la clave primaria
    
}