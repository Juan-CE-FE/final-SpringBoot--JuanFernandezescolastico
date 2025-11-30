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

@CrossOrigin // Permite peticiones desde cualquier origen
@RestController // Indica que es un controlador REST
@RequestMapping("/api/v1/projects") // Ruta base para las peticiones
@AllArgsConstructor // Genera un constructor con todos los atributos
public class ProjectController {

    ProjectService projectService; // Instancia del servicio para manejar la lógica de negocio
    
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() { // Maneja las peticiones GET a la ruta base
        List<Project> projects = projectService.getAllProjects(); // Llama al servicio para obtener todos los proyectos
        return ResponseEntity.ok().body(projects); // Devuelve la lista de proyectos con estado 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Integer id) { // Maneja las peticiones GET a /{id}
                                                                // PathVariable extrae el id de la URL
        ResponseEntity <Project> response = ResponseEntity.ok(projectService.getProjectById(id)); // Llama al servicio para obtener el proyecto por id
        return response; // Devuelve el proyecto con estado 200 OK
    }

    @GetMapping("/buscar/{word}")
    public ResponseEntity<List<Project>> getProjectsByWord(@PathVariable String word) { // Maneja las peticiones GET a /buscar/{word}
                                                                // PathVariable extrae la palabra de la URL
        List<Project> projects = projectService.getProjectsByWord(word); // Llama al servicio para obtener los proyectos que contienen la palabra
        return ResponseEntity.ok().body(projects); // Devuelve la lista de proyectos con estado 200 OK
    }

    @PostMapping("")
    public ResponseEntity<Project> postProject(@RequestBody Project proyecto) { // Maneja las peticiones POST a la ruta base
                                                                // RequestBody extrae el proyecto del cuerpo de la petición
       ResponseEntity<Project> response = ResponseEntity.ok(projectService.postProject(proyecto)); // Llama al servicio para crear un nuevo proyecto
       return response; // Devuelve el proyecto creado con estado 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> putProject(@PathVariable Integer id, @RequestBody Project proyecto) { // Maneja las peticiones PUT a /{id}
                                                                // PathVariable extrae el id de la URL
                                                                // RequestBody extrae el proyecto del cuerpo de la petición
        ResponseEntity<Project> response = ResponseEntity.ok(projectService.putProject(id, proyecto)); // Llama al servicio para actualizar el proyecto
        return response; // Devuelve el proyecto actualizado con estado 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) { // Maneja las peticiones DELETE a /{id}
                                                                // PathVariable extrae el id de la URL
    projectService.deleteProject(id); // Llama al servicio para eliminar el proyecto
    return ResponseEntity.ok("Proyecto eliminado correctamente"); // Devuelve un mensaje de éxito con estado 200 OK
}





}