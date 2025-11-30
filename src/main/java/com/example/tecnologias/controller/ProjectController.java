package com.example.tecnologias.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tecnologias.service.ProjectService;
import com.example.tecnologias.persistence.model.Project;
import lombok.AllArgsConstructor;

@CrossOrigin    
@RestController  
@RequestMapping("/api/v1/projects")  
@AllArgsConstructor
public class ProjectController {

    ProjectService projectService;
    
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok().body(projects);  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
        ResponseEntity <Project> response = ResponseEntity.ok(projectService.getProjectById(id));
        return response;
    }

    @GetMapping("/buscar/{word}")
    public ResponseEntity<List<Project>> getProjectsByWord(@PathVariable String word) {
        List<Project> projects = projectService.getProjectsByWord(word);
        return ResponseEntity.ok().body(projects);
    }

    @PostMapping("")
    public ResponseEntity<Project> postProject(@RequestBody Project proyecto) {
       ResponseEntity<Project> response = ResponseEntity.ok(projectService.postProject(proyecto));   
       return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> putProject(@PathVariable Integer id, @RequestBody Project proyecto) {
        ResponseEntity<Project> response = ResponseEntity.ok(projectService.putProject(id, proyecto));   
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) {
    projectService.deleteProject(id);
    return ResponseEntity.ok("Proyecto eliminado correctamente");
}





}