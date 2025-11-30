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
import com.example.tecnologias.service.DeveloperService;
import com.example.tecnologias.persistence.model.Developer;
import lombok.AllArgsConstructor;

@CrossOrigin    
@RestController  
@RequestMapping("/api/v1/developers")  
@AllArgsConstructor
public class DeveloperController {

    DeveloperService developerService;
    
    @GetMapping
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        List<Developer> developers = developerService.getAllDevelopers();
        return ResponseEntity.ok().body(developers);  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Integer id) {
        ResponseEntity<Developer> response = ResponseEntity.ok(developerService.getDeveloperById(id));
        return response;
    }

    @PostMapping("")
    public ResponseEntity<Developer> postDeveloper(@RequestBody Developer desarrollador) {
       ResponseEntity<Developer> response = ResponseEntity.ok(developerService.postDeveloper(desarrollador));   
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> putDeveloper(@RequestBody Developer desarrollador, @PathVariable Integer id) {
       ResponseEntity<Developer> response = ResponseEntity.ok(developerService.putDeveloper(id, desarrollador));   
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Integer id) {
    developerService.deleteDeveloper(id);
    return ResponseEntity.ok("Desarrollador eliminado correctamente");
    }



}