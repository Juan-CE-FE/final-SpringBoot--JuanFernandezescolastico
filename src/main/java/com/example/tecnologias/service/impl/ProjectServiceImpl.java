package com.example.tecnologias.service.impl;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.tecnologias.service.ProjectService;
import com.example.tecnologias.persistence.model.Project;
import com.example.tecnologias.persistence.model.Status;
import com.example.tecnologias.persistence.model.Technology;
import com.example.tecnologias.persistence.model.Developer;
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

        if (proyecto.getTechnologies() != null && !proyecto.getTechnologies().isEmpty()) { // Verifico que no venga nulo o vacío
       
        Set<Technology> tecnologiasValidadas = new HashSet<>(); // Creo un set para almacenar las tecnologías validadas (Set poque al ser 
                                                               // ManyToMany no puede haber tecnologías repetidas) y porque project no puede
                                                               // cargar varias listas, por lo que uso Set y en developer list.
        
        for (Technology tech : proyecto.getTechnologies()) { // Recorro cada tecnología recibida
        
            Technology tecnologiaBd = technologyRepository.findById(tech.getTechId()) // Busco la tecnología por su ID
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada con ID: " + tech.getTechId()));
        
            tecnologiasValidadas.add(tecnologiaBd); // Si la encuentra, la añado a la lista de validadas
        
        }
        
        proyecto.setTechnologies(tecnologiasValidadas); // Asigno las tecnologías validadas al proyecto
    
    }

    if (proyecto.getDevelopers() != null && !proyecto.getDevelopers().isEmpty()) { // Verifico que no venga nulo o vacío
        
        Set<Developer> developersValidadas = new HashSet<>(); // Uso Set para evitar duplicados
        
        for (Developer dev : proyecto.getDevelopers()) { // Recorro cada developer recibido
        
            Developer developerBd = developerRepository.findById(dev.getDevId()) // Busco el developer por su ID
                .orElseThrow(() -> new RuntimeException("Developer no encontrado ID: " + dev.getDevId()));
        
            developersValidadas.add(developerBd); // Si lo encuentra, lo añado al set de validadas
        }
        
        proyecto.setDevelopers(developersValidadas); // Asigno los developers validados al proyecto
    }

        Project proyectoGuardado = projectRepository.save(proyecto); // Uso el método save para guardarlo en BBDD

        return projectRepository.findById(proyectoGuardado.getProjectId()) // Recargo el proyecto con todas sus relaciones
            .orElse(proyectoGuardado); // Devuelvo el proyecto completo
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

        if (proyecto.getTechnologies() != null) { // Verifico que no venga nulo
        
        Set<Technology> tecnologiasValidadas = new HashSet<>(); // Creo una lista para almacenar las tecnologías validadas
        
        for (Technology tech : proyecto.getTechnologies()) { // Recorro cada tecnología recibida
        
            Technology tecnologiaBd = technologyRepository.findById(tech.getTechId()) // Busco la tecnología por su ID
                .orElseThrow(() -> new RuntimeException("Tecnología no encontrada ID: " + tech.getTechId()));
        
            tecnologiasValidadas.add(tecnologiaBd); // Si la encuentra, la añado a la lista
        }
        
        proyectoEditado.setTechnologies(tecnologiasValidadas); // Asigno las tecnologías validadas al proyecto editado
    
    }

    if (proyecto.getDevelopers() != null) { // Verifico que no venga nulo

        Set<Developer> developersValidadas = new HashSet<>(); // Uso Set para evitar duplicados
        for (Developer dev : proyecto.getDevelopers()) { // Recorro cada developer recibido
            
            Developer developerBd = developerRepository.findById(dev.getDevId()) // Busco el developer por su ID
                .orElseThrow(() -> new RuntimeException("Developer no encontrado ID: " + dev.getDevId()));
            developersValidadas.add(developerBd); // Si lo encuentra, lo añado al set
        
        }


        proyectoEditado.setDevelopers(developersValidadas); // Asigno los developers validados al proyecto editado
    }
        
        Project proyectoActualizado = projectRepository.save(proyectoEditado); // Guardo los cambios
        
        // Recargo el proyecto con todas sus relaciones para devolverlo completo
        return projectRepository.findById(proyectoActualizado.getProjectId())
            .orElse(proyectoActualizado);
    }

    @Override
    public void deleteProject(Integer id) { // recibe un id
        // Verifico que el proyecto existe antes de eliminar
        Project proyecto = projectRepository.findById(id) // Busca si existe
            .orElseThrow(() -> new RuntimeException("No se encuentra ningun proyecto con la id: " + id));
        projectRepository.delete(proyecto); // Elimina el proyecto
    }
}