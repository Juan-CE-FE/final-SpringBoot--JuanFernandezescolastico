package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.StatusService;
import com.example.tecnologias.persistence.model.Status;
import com.example.tecnologias.persistence.repository.StatusRepository;
import lombok.AllArgsConstructor;

// Clase que desarrolla la lógica de los métodos los cuales se ha creado la firma en service

@AllArgsConstructor
@Service
public class StatusServiceImpl implements StatusService { // Implementa StatusService para usar
                                                            // sus métodos

    StatusRepository statusRepository; // Instanciamos el StatusRepository
    
    // Get All Status
    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll(); // Devuelve una lista de Status con el findAll de JPA
    }


    // Get Status por Id
    @Override
    public Status getStatusById(Integer id) { // Recibe un id
        return statusRepository.findById(id). // Busca por id y devuelve
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
    }


    // Post
    @Override
    public Status postStatus(Status estado) { // Recibe un estado
       return statusRepository.save(estado); // Usa el método save para guardarlo en BBDD
    }


    // Put

    @Override
public Status putStatus(Integer id, Status estado) {    // Recibe un id y un estado
    Status estadoEditado = statusRepository.findById(id) // Busca si existe ese estado
        .orElseThrow(() -> new RuntimeException("No se ha encontrado un Estado con id: " + id));
    
    // Actualizo los campos
    estadoEditado.setStatusName(estado.getStatusName());
    
    return statusRepository.save(estadoEditado); // Guardo y devuelvo el estado editado
    }

    // Delete

    @Override
    public void deleteStatus(Integer id) { // Recibe un id
    // Verificar que el proyecto existe antes de eliminar
    Status estado = statusRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ningun estado con la id: " + id));
        statusRepository.delete(estado);
    }




}