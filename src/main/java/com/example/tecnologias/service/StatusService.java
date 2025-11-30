package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Status;

// Interfaz que crea la firma de los métodos que en impl desarrollaré apoyado de los métodos JPA
public interface StatusService {
    public List<Status> getAllStatus(); // Devuelve una lista con todos los status
    public Status getStatusById(Integer id); // recibe un id y devuelve el status con ese id
    public Status postStatus(Status estado); // Recibe un Status nuevo y lo crea en la base de datos
    public Status putStatus(Integer id, Status estado); // Recibe un id y un nuevo estado y modifica el
                                                        // estado del id pasado con el nuecvo
    public void deleteStatus(Integer id); // recibe un id y elimina el estado con ese id
}