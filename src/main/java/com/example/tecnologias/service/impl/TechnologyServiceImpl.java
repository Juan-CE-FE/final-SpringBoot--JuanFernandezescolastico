package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.TechnologyService;
import com.example.tecnologias.persistence.model.Technology;
import com.example.tecnologias.persistence.repository.TechnologyRepository;
import lombok.AllArgsConstructor;

// Clase que desarrolla la lógica de los métodos los cuales se ha creado la firma en service

@AllArgsConstructor
@Service
public class TechnologyServiceImpl implements TechnologyService { // Implementa TechnologyService para usar
                                                            // sus métodos

    TechnologyRepository technologyRepository; // Instanciamos el TechnologyRepository
    
    @Override
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll(); // Devuelve una lista de Technology con el findAll de JPA
    }

    @Override
    public Technology getTechnologiesById(Integer id) { // Recibe un id
        return technologyRepository.findById(id). // Busca por id y devuelve
        orElseThrow(() -> new RuntimeException("No se ha encontrado esa Technology"));
    }

    @Override
    public Technology postTechnology(Technology tecnologia){ // Recibe una tecnologia
        return technologyRepository.save(tecnologia); // Usa el método save para guardarlo en BBDD
    }

    @Override
    public Technology putTechnology(Integer id, Technology tecnologia) { // Recibe un id y una tecnologia
    Technology tecnologiaEditada = technologyRepository.findById(id) // Busca si existe esa tecnologia
        .orElseThrow(() -> new RuntimeException("No se ha encontrado una tecnologia con id: " + id));
    
    // Actualizo los campos
    tecnologiaEditada.setTechName(tecnologia.getTechName());    
    
    return technologyRepository.save(tecnologiaEditada); // Guardo y devuelvo la tecnologia editada
    }

    @Override
    public void deleteTechnology(Integer id) { // Recibe un id
    // Verificar que el proyecto existe antes de eliminar
    Technology tecnologia = technologyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ninguna tecnologia con la id: " + id));
        technologyRepository.delete(tecnologia);
    }





}