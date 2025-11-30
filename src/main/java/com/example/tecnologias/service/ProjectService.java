package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Project;

public interface ProjectService {
    public List<Project> getAllProjects();
    public Project getProjectById(Integer id);
    public Project postProject(Project proyecto);
    public Project putProject(Integer id, Project proyecto);
    public void deleteProject(Integer id);
    public List<Project> getProjectsByWord(String word);
}