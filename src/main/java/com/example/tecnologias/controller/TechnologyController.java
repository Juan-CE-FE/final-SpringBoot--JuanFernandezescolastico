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
import com.example.tecnologias.service.TechnologyService;
import com.example.tecnologias.persistence.model.Technology;
import lombok.AllArgsConstructor;

@CrossOrigin    
@RestController  
@RequestMapping("/api/v1/technologies")  
@AllArgsConstructor
public class TechnologyController {

    TechnologyService technologyService;
    
    @GetMapping
    public ResponseEntity<List<Technology>> getAllTechnologies() {
        List<Technology> technologies = technologyService.getAllTechnologies();
        return ResponseEntity.ok().body(technologies);  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getTechnologiesById(@PathVariable Integer id) {
        ResponseEntity <Technology> response = ResponseEntity.ok(technologyService.
        getTechnologiesById(id));
        return response;
    }

    @PostMapping("")
    public ResponseEntity<Technology> postTechnology(@RequestBody Technology tecnologia) {
       ResponseEntity<Technology> response = ResponseEntity.ok(technologyService.
       postTechnology(tecnologia));   
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technology> putTechnology(@PathVariable Integer id, @RequestBody Technology tecnologia) {
        ResponseEntity<Technology> response = ResponseEntity.ok(technologyService.putTechnology(id, tecnologia));   
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Integer id) {
    technologyService.deleteTechnology(id);
    return ResponseEntity.ok("Tecnología eliminada correctamente");
    }




}