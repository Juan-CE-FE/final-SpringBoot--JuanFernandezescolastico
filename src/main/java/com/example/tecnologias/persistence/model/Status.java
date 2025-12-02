package com.example.tecnologias.persistence.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@NoArgsConstructor 
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;    
    
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY) // relación OneToMany porque un estado puede
                                                            // estar enn varios proyectos, pero un proyecto
                                                            // no puede tener varios estados a la vez-
                                                            // Además es LAZY que lo que significa es que
                                                            // no se cargará la lista de proyectos
                                                            //  hasta que se le pida.
    @JsonIgnore
    private List<Project> projects;
}