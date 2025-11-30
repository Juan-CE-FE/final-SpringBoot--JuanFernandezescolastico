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

@CrossOrigin // Permite peticiones desde cualquier origen
@RestController // Indica que es un controlador REST
@RequestMapping("/api/v1/technologies") // Ruta base para las peticiones  
@AllArgsConstructor // Genera un constructor con todos los atributos
public class TechnologyController {

    TechnologyService technologyService; // Instancia del servicio para manejar la lógica de negocio
    
    @GetMapping
    public ResponseEntity<List<Technology>> getAllTechnologies() { // Maneja las peticiones GET a la ruta base
        List<Technology> technologies = technologyService.getAllTechnologies(); // Llama al servicio para obtener todas las tecnologías
        return ResponseEntity.ok().body(technologies);  // Devuelve la lista de tecnologías con estado 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getTechnologiesById(@PathVariable Integer id) { // Maneja las peticiones GET a /{id}
                                                                                // PathVariable extrae el id de la URL
        ResponseEntity <Technology> response = ResponseEntity.ok(technologyService.
        getTechnologiesById(id)); // Llama al servicio para obtener la tecnología por id
        return response; // Devuelve la tecnología con estado 200 OK
    }

    @PostMapping("")
    public ResponseEntity<Technology> postTechnology(@RequestBody Technology tecnologia) { // Maneja las peticiones POST a la ruta base
                                                                                // RequestBody extrae la tecnología del cuerpo de la petición
       ResponseEntity<Technology> response = ResponseEntity.ok(technologyService.
       postTechnology(tecnologia)); // Llama al servicio para crear una nueva tecnología
        return response; // Devuelve la tecnología creada con estado 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technology> putTechnology(@PathVariable Integer id, @RequestBody Technology tecnologia) { // Maneja las peticiones PUT a /{id}
                                                                                // PathVariable extrae el id de la URL
                                                                                // RequestBody extrae la tecnología del cuerpo de la petición
        ResponseEntity<Technology> response = ResponseEntity.ok(technologyService.putTechnology(id, tecnologia));   
        return response; // Devuelve la tecnología actualizada con estado 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Integer id) { // Maneja las peticiones DELETE a /{id}
                                                                                // PathVariable extrae el id de la URL
    technologyService.deleteTechnology(id); // Llama al servicio para eliminar la tecnología
    return ResponseEntity.ok("Tecnología eliminada correctamente"); // Devuelve un mensaje de éxito con estado 200 OK
    }




}