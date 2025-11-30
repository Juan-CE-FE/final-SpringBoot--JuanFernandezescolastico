package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Technology;

public interface TechnologyService {
    public List<Technology> getAllTechnologies();
    public Technology getTechnologiesById(Integer id);
    public Technology postTechnology(Technology tecnologia);
    public Technology putTechnology(Integer id, Technology tecnologia);
    public void deleteTechnology(Integer id);
}