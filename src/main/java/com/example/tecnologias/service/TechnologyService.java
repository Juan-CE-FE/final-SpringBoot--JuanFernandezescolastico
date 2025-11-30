package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Technology;

// Interfaz que crea la firma de los métodos que en impl desarrollaré apoyado de los métodos JPA
public interface TechnologyService {
    public List<Technology> getAllTechnologies(); // Devuelve una lista con todas las tecnologías
    public Technology getTechnologiesById(Integer id); // recibe un id y devuelve la tecnología con ese id
    public Technology postTechnology(Technology tecnologia); // Recibe una tecnología nueva y la crea
    public Technology putTechnology(Integer id, Technology tecnologia); // recibe un id y una tecnología
                                                                    // y modifica la tecnología con ese id
                                                                    // por la nueva
    public void deleteTechnology(Integer id); // recibe un id y elimina la tecnología con ese id
}