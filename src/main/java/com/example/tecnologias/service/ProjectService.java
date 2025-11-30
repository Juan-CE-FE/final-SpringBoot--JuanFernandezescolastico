package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Project;

// Interfaz que crea la firma de los métodos que en impl desarrollaré apoyado de los métodos JPA
public interface ProjectService {
    public List<Project> getAllProjects(); // Devuelve una lista con todos los proyectos
    public Project getProjectById(Integer id); // recibe un Id y devuelve el proyecto con ese id
    public Project postProject(Project proyecto); // Recibe los datos de un proyecto y lo crea
    public Project putProject(Integer id, Project proyecto); // recibe un id y un proyecto y cambia el 
                                                            // proyecto que tiene el id enviado
    public void deleteProject(Integer id); // recibe un id de un proyecto y lo elimina
    public List<Project> getProjectsByWord(String word); // recibe una palabra y devuelve los proyectos 
                                                        // que tengan esa palabra en el título
}