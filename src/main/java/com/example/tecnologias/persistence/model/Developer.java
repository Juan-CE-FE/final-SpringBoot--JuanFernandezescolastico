package com.example.tecnologias.persistence.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Integer devId;

    @Column(name = "devname", nullable = false, unique = true, length = 20)
    private String devname;
  
    @Column(name = "dev_surname", nullable = false, length = 60)
    private String devSurname;

    @Column(name = "email", nullable = false, unique = true, length = 90)
    private String email;

    @Column(name = "linkedin_url", nullable = false, length = 90)
    private String linkedinUrl;

    @Column(name = "github_url", nullable = false, length = 90)
    private String githubUrl;

    @ManyToMany(mappedBy = "developers", fetch = FetchType.LAZY) // Relación ManyToMany porque
                                                                // un desarrollador puede tener
                                                                // múltiples proyectos y viceversa
                                                                // en proyecto que es el dueño, está
                                                                // la relación completa, aquí simplemente
                                                                // con mappedBy, se referencia

    @JsonIgnore // Para que no se serialice el json más veces porque sino sería un bucle infinito
    private Set<Project> projects; // Esto me permite ver todos lo proyectos con un get
                                    // por ejemplo desde developers
}