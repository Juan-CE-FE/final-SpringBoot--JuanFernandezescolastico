package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.ProjectService;
import com.example.tecnologias.persistence.model.Project;
import com.example.tecnologias.persistence.model.Status;
import com.example.tecnologias.persistence.repository.ProjectRepository;
import com.example.tecnologias.persistence.repository.StatusRepository;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    private StatusRepository statusRepository;

    
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    @Override
    public Project getProjectById(Integer id) {
        return projectRepository.findById(id).
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Project"));
    }

    @Override
    public List<Project> getProjectsByWord(String word) {
        return projectRepository.findByProjectNameContainingIgnoreCase(word);
    }


    @Override
    public Project postProject(Project proyecto) { // Añado el status por la relacion que tienen entre Project y status, para pasarselo por JSON
       Status statusBd = statusRepository.findById(proyecto.getStatus().getStatusId())
            .orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
        proyecto.setStatus(statusBd);

        return projectRepository.save(proyecto);
    }


    @Override
    public Project putProject(Integer id, Project proyecto) {
    Project proyectoEditado = projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha encontrado un proyecto con id: " + id));
    
    // Actualizo los campos
    proyectoEditado.setProjectName(proyecto.getProjectName());
    proyectoEditado.setDescription(proyecto.getDescription());
    proyectoEditado.setStartDate(proyecto.getStartDate());
    proyectoEditado.setEndDate(proyecto.getEndDate());
    proyectoEditado.setDemoUrl(proyecto.getDemoUrl());
    proyectoEditado.setPicture(proyecto.getPicture());
    
    
    Status statusBd = statusRepository.findById(proyecto.getStatus().getStatusId())
        .orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
    proyectoEditado.setStatus(statusBd);
    
    return projectRepository.save(proyectoEditado);
}

@Override
public void deleteProject(Integer id) {
    // Verificar que el proyecto existe antes de eliminar
    Project proyecto = projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encuentra ningun proyecto con la id: " + id));
    projectRepository.delete(proyecto);
}









}