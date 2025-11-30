package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.StatusService;
import com.example.tecnologias.persistence.model.Status;
import com.example.tecnologias.persistence.repository.StatusRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StatusServiceImpl implements StatusService {

    StatusRepository statusRepository;
    
    // Get All Status
    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }


    // Get Status por Id
    @Override
    public Status getStatusById(Integer id) {
        return statusRepository.findById(id).
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
    }


    // Post
    @Override
    public Status postStatus(Status estado) {
       return statusRepository.save(estado);
    }


    // Put

    @Override
    public Status putStatus(Integer id, Status estado) {
    Status estadoEditado = statusRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha encontrado un Estado con id: " + id));
    
    // Actualizo los campos
    estadoEditado.setStatusName(estado.getStatusName());
    
    return statusRepository.save(estadoEditado);
    }

    // Delete

    @Override
    public void deleteStatus(Integer id) {
    // Verificar que el proyecto existe antes de eliminar
    Status estado = statusRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ningun estado con la id: " + id));
        statusRepository.delete(estado);
    }




}