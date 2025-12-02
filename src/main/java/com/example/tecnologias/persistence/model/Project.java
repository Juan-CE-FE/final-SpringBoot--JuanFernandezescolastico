package com.example.tecnologias.persistence.model;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor  
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")    
    private Integer projectId;  
    
    @Column(name = "project_name", nullable = false, unique = true, length = 150) 
    private String projectName;
    
    @Column(name = "description", nullable = false, length = 150) 
    private String description;
    
    @Column(name = "start_date", nullable = false) 
    private String startDate;
    
    @Column(name = "end_date", nullable = false) 
    private String endDate;
    
    @Column(name = "demo_url", nullable = false, length = 150) 
    private String demoUrl;
    
    @Column(name = "picture", nullable = false, length = 150) 
    private String picture;

    @ManyToOne(fetch = FetchType.EAGER) // Es eager porque carga inmediatamente, ya que es la entidad
                                        // más importante y many to one porque un status pueden tenerlo
                                        // varios proyectos pero un proyecto solo tiene un status
    @JoinColumn(name = "status_status_id", referencedColumnName = "status_id") // Relacionada con Status
                                                                            // Mediante las columnas status_status_id
                                                                            // (Columna de project) y status_id
                                                                            // (Columna de status)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Status status;
    
    @ManyToMany(fetch = FetchType.LAZY) // ManyToMany porque una tecnología se usa en muchos projectos
                                        // y un proyecto puede usar varias tecnologías. Y es LAZY
                                        // porque no se va a cargar hasta que la use.
    @JoinTable(name = "technologies_used_in_projects", // Guarda las relaciones en esta tabla.
                // La relación de abajo, dice que en la tabla technologies_used_in_projects, en la 
                // columna projects_projects_id, apunta/referencia a project_id de projects y con
                // tecnología igual
               joinColumns = {@JoinColumn(name = "projects_project_id", referencedColumnName = "project_id")}, 
               inverseJoinColumns = {@JoinColumn(name = "tecnologia_tecnologia_id", referencedColumnName = "tech_id")})
    @EqualsAndHashCode.Exclude
    private Set<Technology> technologies; // Set porque no puede haber tecnologías repetidas en un proyecto.
                                        // y al ser LAZY, me permite cargar las tecnologías y después los developers con list.
    
    @ManyToMany(fetch = FetchType.LAZY) // ManyToMany, indica que un proyecto puede tener varios
                                        // desarrolladores y que un desarrollador puede tener varios proyectos
    @JoinTable(name = "developers_worked_on_projects", // Guarda las relaciones en esta tabla
                // La relación de abajo indica que la columna projects_project_id apunta a project_id de la tabla projects
                // y la columna developer_dev_id referencia a dev_id de la tabla developers
               joinColumns = {@JoinColumn(name = "projects_project_id", referencedColumnName = "project_id")},
               inverseJoinColumns = {@JoinColumn(name = "developer_dev_id", referencedColumnName = "dev_id")})

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @EqualsAndHashCode.Exclude
    private Set<Developer> developers; // Set para evitar developers duplicados al cargar múltiples colecciones

    // Exclude technologies from equals/hashCode to avoid potential recursion when
    // entities are bidirectionally linked or when Hibernate wraps collections.
}