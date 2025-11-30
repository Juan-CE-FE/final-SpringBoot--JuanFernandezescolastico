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
import com.example.tecnologias.service.StatusService;
import com.example.tecnologias.persistence.model.Status;
import lombok.AllArgsConstructor;

@CrossOrigin // Permite peticiones desde cualquier origen
@RestController // Indica que es un controlador REST
@RequestMapping("/api/v1/status")  // Ruta base para las peticiones
@AllArgsConstructor // Genera un constructor con todos los atributos
public class StatusController {

    StatusService statusService; // Instancia del servicio para manejar la lógica de negocio
    
    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() { // Maneja las peticiones GET a la ruta base
        List<Status> statusList = statusService.getAllStatus(); // Llama al servicio para obtener todos los status
        return ResponseEntity.ok().body(statusList); // Devuelve la lista de status con estado 200 OK
    }


    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Integer id) { // Maneja las peticiones GET a /{id}
                                                                // PathVariable extrae el id de la URL
        ResponseEntity <Status> response = ResponseEntity.ok(statusService.getStatusById(id)); // Llama al servicio para obtener el status por id
        return response; // Devuelve el status con estado 200 OK
    }


    @PostMapping("")
    public ResponseEntity<Status> postStatus(@RequestBody Status estado) { // Maneja las peticiones POST a la ruta base
                                                                // RequestBody extrae el status del cuerpo de la petición
       ResponseEntity<Status> response = ResponseEntity.ok(statusService.postStatus(estado)); // Llama al servicio para crear un nuevo status
        return response; // Devuelve el status creado con estado 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> putStatus(@PathVariable Integer id, @RequestBody Status estado) { // Maneja las peticiones PUT a /{id}
                                                                // PathVariable extrae el id de la URL
                                                                // RequestBody extrae el status del cuerpo de la petición
        ResponseEntity<Status> response = ResponseEntity.ok(statusService.putStatus(id, estado)); // Llama al servicio para actualizar el status
        return response; // Devuelve el status actualizado con estado 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStatus(@PathVariable Integer id) { // Maneja las peticiones DELETE a /{id}
                                                                // PathVariable extrae el id de la URL
    statusService.deleteStatus(id); // Llama al servicio para eliminar el status
    return ResponseEntity.ok("Estado eliminado correctamente"); // Devuelve un mensaje de éxito con estado 200 OK
    }




}