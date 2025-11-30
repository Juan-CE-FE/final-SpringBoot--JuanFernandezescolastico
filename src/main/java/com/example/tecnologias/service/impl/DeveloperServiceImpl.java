package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.DeveloperService; 
import com.example.tecnologias.persistence.model.Developer;
import com.example.tecnologias.persistence.repository.DeveloperRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService {

    DeveloperRepository developerRepository;
    
    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDeveloperById(Integer id) {
        return developerRepository.findById(id).
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Developer"));
    }

    @Override
    public Developer postDeveloper(Developer desarrollador) {
        return developerRepository.save(desarrollador);
    }


    @Override
    public Developer putDeveloper(Integer id, Developer desarrollador) {
    Developer desarrolladorEditado = developerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha encontrado un Desarrollador con id: " + id));
    
    // Actualizo los campos
    desarrolladorEditado.setDevname(desarrollador.getDevname());
    desarrolladorEditado.setDevSurname(desarrollador.getDevSurname());
    desarrolladorEditado.setEmail(desarrollador.getEmail());
    desarrolladorEditado.setLinkedinUrl(desarrollador.getLinkedinUrl());
    desarrolladorEditado.setGithubUrl(desarrollador.getGithubUrl());
    
    return developerRepository.save(desarrolladorEditado);
}

@Override
public void deleteDeveloper(Integer id) {
    // Verificar que el proyecto existe antes de eliminar
    Developer desarrollador = developerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ningun desarrollador con la id: " + id));
    developerRepository.delete(desarrollador);
}



}