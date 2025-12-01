package com.example.tecnologias.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.ProjectService;
import com.example.tecnologias.persistence.model.Project;
import com.example.tecnologias.persistence.model.Status;
import com.example.tecnologias.persistence.repository.ProjectRepository;
import com.example.tecnologias.persistence.repository.StatusRepository;
import com.example.tecnologias.persistence.repository.TechnologyRepository;
import com.example.tecnologias.persistence.repository.DeveloperRepository;
import lombok.AllArgsConstructor;

// Clase que desarrolla la lógica de los métodos los cuales se ha creado la firma en service

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService { // Implementa de projectService para
                                                            // usar sus métodos

    ProjectRepository projectRepository; // Instancio repositorio de project.
    private StatusRepository statusRepository; // Instancio repositorio de status, ya que para las
                                            // relaciones lo necesitaré en el Post y en el Put.
    private TechnologyRepository technologyRepository; // Instancio repositorio de technology para las relaciones
    private DeveloperRepository developerRepository; // Instancio repositorio de developer para las relaciones

    
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll(); // Usa el método findAll para devolver la lista de los
                                            // proyectos existentes.
    }


    @Override
    public Project getProjectById(Integer id) { // Recibe un id
        return projectRepository.findById(id). // Busca por id y devuelve
        orElseThrow(() -> new RuntimeException("No se ha encontrado ese Project"));
    }

    @Override
    public List<Project> getProjectsByWord(String word) { // recibe una palabra
        return projectRepository.findByProjectNameContainingIgnoreCase(word); // Devuelve el o los
                                                                    // proyectos que contengan esa palabra
    }


    @Override
    public Project postProject(Project proyecto) { // Añado el status por la relacion que tienen
                                                // entre Project y status, para pasarselo por JSON
       Status statusBd = statusRepository.findById(proyecto.getStatus().getStatusId())
            .orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
        proyecto.setStatus(statusBd);

        // Para evitar problemas con relaciones incompletas, no asignamos technologies ni developers aquí
        // Se crearán relaciones vacías que luego se pueden llenar por otros medios
        
        Project proyectoGuardado = projectRepository.save(proyecto); // Uso el método save para guardarlo en BBDD

        return projectRepository.findById(proyectoGuardado.getProjectId())
            .orElse(proyectoGuardado);
    }


    @Override
    public Project putProject(Integer id, Project proyecto) { // Recibe un id y un proyecto
        Project proyectoEditado = projectRepository.findById(id) // Busca si existe ese proyecto
            .orElseThrow(() -> new RuntimeException("No se ha encontrado un proyecto con id: " + id));
        
        // Actualizo los campos básicos
        proyectoEditado.setProjectName(proyecto.getProjectName());
        proyectoEditado.setDescription(proyecto.getDescription());
        proyectoEditado.setStartDate(proyecto.getStartDate());
        proyectoEditado.setEndDate(proyecto.getEndDate());
        proyectoEditado.setDemoUrl(proyecto.getDemoUrl());
        proyectoEditado.setPicture(proyecto.getPicture());
        
        // Actualizo el status
        Status statusBd = statusRepository.findById(proyecto.getStatus().getStatusId())
            .orElseThrow(() -> new RuntimeException("No se ha encontrado ese Status"));
        proyectoEditado.setStatus(statusBd);
        
        // NOTA: No actualizamos technologies ni developers aquí para evitar problemas
        // con objetos incompletos. Las relaciones se mantienen como estaban.
        
        Project proyectoActualizado = projectRepository.save(proyectoEditado);
        
        // Recargo el proyecto con todas sus relaciones para devolverlo completo
        return projectRepository.findById(proyectoActualizado.getProjectId())
            .orElse(proyectoActualizado);
    }

    @Override
    public void deleteProject(Integer id) { // recibe un id
        // Verificar que el proyecto existe antes de eliminar
        Project proyecto = projectRepository.findById(id) // Busca si existe
            .orElseThrow(() -> new RuntimeException("No se encuentra ningun proyecto con la id: " + id));
        projectRepository.delete(proyecto); // Elimina el proyecto
    }
}