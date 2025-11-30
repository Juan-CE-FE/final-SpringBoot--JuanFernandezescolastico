package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Developer;

public interface DeveloperService {
    public List<Developer> getAllDevelopers();
    public Developer getDeveloperById(Integer id);
    public Developer postDeveloper(Developer desarrollador);
    public Developer putDeveloper(Integer id, Developer desarrollador);
    public void deleteDeveloper(Integer id);
}