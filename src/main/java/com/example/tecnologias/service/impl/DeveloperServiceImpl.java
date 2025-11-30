package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.DeveloperService; 
import com.example.tecnologias.persistence.model.Developer;
import com.example.tecnologias.persistence.repository.DeveloperRepository;
import lombok.AllArgsConstructor;

// Clase que desarrolla la lógica de los métodos los cuales se ha creado la firma en service

@AllArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService { // Implementa el servicio

    DeveloperRepository developerRepository; // Creo estancia de repository para usar los métodos JPA
    
    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll(); // Usa el método findAll de JPA para devolver una lista 
                                                // de todos los Developers.
    }

    @Override
    public Developer getDeveloperById(Integer id) { // Recibe un id 
        return developerRepository.findById(id). // Usa el método de buscar por id.
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Developer"));
    }

    @Override
    public Developer postDeveloper(Developer desarrollador) { // Recibe un desarrollador
        return developerRepository.save(desarrollador); // Uso el método save para guardarlo en BBDD
    }


    @Override
    public Developer putDeveloper(Integer id, Developer desarrollador) {
    Developer desarrolladorEditado = developerRepository.findById(id) // Busca si existe ese desarrollador
        .orElseThrow(() -> new RuntimeException("No se ha encontrado un Desarrollador con id: " + id));
    
    // Actualizo los campos
    desarrolladorEditado.setDevname(desarrollador.getDevname());
    desarrolladorEditado.setDevSurname(desarrollador.getDevSurname());
    desarrolladorEditado.setEmail(desarrollador.getEmail());
    desarrolladorEditado.setLinkedinUrl(desarrollador.getLinkedinUrl());
    desarrolladorEditado.setGithubUrl(desarrollador.getGithubUrl());
    
    return developerRepository.save(desarrolladorEditado); // Guardo
}

@Override
public void deleteDeveloper(Integer id) {
    // Verificar que el proyecto existe antes de eliminar
    Developer desarrollador = developerRepository.findById(id) //  Busca por id
        .orElseThrow(() -> new RuntimeException("No se encuentra ningun desarrollador con la id: " + id));
    developerRepository.delete(desarrollador);
}



}