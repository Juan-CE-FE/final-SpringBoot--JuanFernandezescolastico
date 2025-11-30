package com.example.tecnologias.service;

import java.util.List;
import com.example.tecnologias.persistence.model.Status;

public interface StatusService {
    public List<Status> getAllStatus();
    public Status getStatusById(Integer id);
    public Status postStatus(Status estado);
    public Status putStatus(Integer id, Status estado);
    public void deleteStatus(Integer id);
}