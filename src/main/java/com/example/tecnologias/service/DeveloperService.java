package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Developer;

// Interfaz que crea la firma de los métodos que en impl desarrollaré apoyado de los métodos JPA
public interface DeveloperService {
    public List<Developer> getAllDevelopers(); // Devuelveuna lista con todos los developers
    public Developer getDeveloperById(Integer id); // recibe un id y devuelve el developer con ese id
    public Developer postDeveloper(Developer desarrollador); // recibe un desarrollador y con ello crea un nuevo desarrollador
    public Developer putDeveloper(Integer id, Developer desarrollador); // Recibe un id y un desarrollador nuevo y modifica el
                                                                        // desarrollador con ese Id
    public void deleteDeveloper(Integer id); // Recibe un id y elimina ese desarrollador
}