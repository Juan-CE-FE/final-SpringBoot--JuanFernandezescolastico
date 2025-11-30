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

@CrossOrigin    
@RestController  
@RequestMapping("/api/v1/status")  
@AllArgsConstructor
public class StatusController {

    StatusService statusService;
    
    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> statusList = statusService.getAllStatus();
        return ResponseEntity.ok().body(statusList);  
    }


    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Integer id) {
        ResponseEntity <Status> response = ResponseEntity.ok(statusService.getStatusById(id));
        return response;
    }


    @PostMapping("")
    public ResponseEntity<Status> postStatus(@RequestBody Status estado) {
       ResponseEntity<Status> response = ResponseEntity.ok(statusService.postStatus(estado));   
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> putStatus(@PathVariable Integer id, @RequestBody Status estado) {
        ResponseEntity<Status> response = ResponseEntity.ok(statusService.putStatus(id, estado));   
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStatus(@PathVariable Integer id) {
    statusService.deleteStatus(id);
    return ResponseEntity.ok("Estado eliminado correctamente");
    }




}