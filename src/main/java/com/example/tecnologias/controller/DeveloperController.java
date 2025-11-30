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

// Controlador que gestiona las peticiones HTTP relacionadas con Developers

@CrossOrigin    // Permite peticiones desde cualquier origen
@RestController  // Indica que es un controlador REST
@RequestMapping("/api/v1/developers")  // Ruta base para las peticiones
@AllArgsConstructor // Genera un constructor con todos los atributos
public class DeveloperController {

    DeveloperService developerService; // Instancia del servicio para manejar la lógica de negocio
    
    @GetMapping // Maneja las peticiones GET a la ruta base
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        List<Developer> developers = developerService.getAllDevelopers(); // Llama al servicio para obtener todos los developers
        return ResponseEntity.ok().body(developers);  // Devuelve la lista de developers con estado 200 OK
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Integer id) { // Maneja las peticiones GET a /{id}
                                                                                // PathVariable extrae el id de la URL
        ResponseEntity<Developer> response = ResponseEntity.ok(developerService.getDeveloperById(id)); // Llama al servicio para obtener el developer por id
        return response; // Devuelve el developer con estado 200 OK
    }

    @PostMapping("")
    public ResponseEntity<Developer> postDeveloper(@RequestBody Developer desarrollador) { // Maneja las peticiones POST a la ruta base
                                                                                // RequestBody extrae el developer del cuerpo de la petición
       ResponseEntity<Developer> response = ResponseEntity.ok(developerService.postDeveloper(desarrollador)); // Llama al servicio para crear un nuevo developer
        return response; // Devuelve el developer creado con estado 200 OK
    }

    @PutMapping("/{id}") 
    public ResponseEntity<Developer> putDeveloper(@RequestBody Developer desarrollador, @PathVariable Integer id) { // Maneja las peticiones PUT a /{id}
                                                                                                                    // RequestBody extrae el developer del cuerpo de la petición
                                                                                                                    // PathVariable extrae el id de la URL
       ResponseEntity<Developer> response = ResponseEntity.ok(developerService.putDeveloper(id, desarrollador)); // Llama al servicio para actualizar el developer
        return response; // Devuelve el developer actualizado con estado 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Integer id) { // Maneja las peticiones DELETE a /{id}
                                                                                // PathVariable extrae el id de la URL
    developerService.deleteDeveloper(id); // Llama al servicio para eliminar el developer
    return ResponseEntity.ok("Desarrollador eliminado correctamente"); // Devuelve un mensaje de éxito con estado 200 OK
    }



}