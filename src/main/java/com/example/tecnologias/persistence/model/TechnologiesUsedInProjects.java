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
@Table(name = "technologies_used_in_projects")
public class TechnologiesUsedInProjects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Indica que muchas filas de esta tabla pueden apuntar a 
                                        // una misma tecnología.
    @JoinColumn(name = "tecnologia_tecnologia_id", referencedColumnName = "tech_id") // tecnologia_tecnologia_id  
                                                                // referencia a la columna tech_id en technology
    @JsonIgnore
    private Technology technology;

    @ManyToOne(fetch = FetchType.LAZY) // Indica que muchas filas de esta tabla pueden apuntar a
                                        // un mismo proyecto.
    @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id")
    @JsonIgnore
    private Project project;
}