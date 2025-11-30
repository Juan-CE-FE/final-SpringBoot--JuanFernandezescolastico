package com.example.tecnologias.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "developers_worked_on_projects") // Tabla que hace de nexo entre Developers y projects
public class DevelopersWorkedOnProjects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id de base de datos autoincremental
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Muchos registtros de esta tabla pueden apuntar al mismo developer 
    @JoinColumn(name = "developer_dev_id", referencedColumnName = "dev_id") // El primero es el id de esta tabla
                                                                            // el segundo la columna en la tabla a la que 
                                                                            // hace referencia
    @JsonIgnore // Evita que se cree un bucle infinito, porque no serializa sin parar
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY) // Muchos registros de esta tabla
                                        // pueden apuntar a un mismo Proyecto
    @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id")
    @JsonIgnore
    private Project project;
}