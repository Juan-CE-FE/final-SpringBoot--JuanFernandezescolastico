package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.TechnologyService;
import com.example.tecnologias.persistence.model.Technology;
import com.example.tecnologias.persistence.repository.TechnologyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TechnologyServiceImpl implements TechnologyService {

    TechnologyRepository technologyRepository;
    
    @Override
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    @Override
    public Technology getTechnologiesById(Integer id) {
        return technologyRepository.findById(id).
        orElseThrow(() -> new RuntimeException("No se ha encontrado esa Technology"));
    }

    @Override
    public Technology postTechnology(Technology tecnologia){
        return technologyRepository.save(tecnologia);
    }

    @Override
    public Technology putTechnology(Integer id, Technology tecnologia) {
    Technology tecnologiaEditada = technologyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha encontrado una tecnologia con id: " + id));
    
    // Actualizo los campos
    tecnologiaEditada.setTechName(tecnologia.getTechName());    
    
    return technologyRepository.save(tecnologiaEditada);
    }

    @Override
    public void deleteTechnology(Integer id) {
    // Verificar que el proyecto existe antes de eliminar
    Technology tecnologia = technologyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ninguna tecnologia con la id: " + id));
        technologyRepository.delete(tecnologia);
    }





}