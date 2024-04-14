package com.example.backend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "personas")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    private Departamentos departamentos;

    public Personas(Integer id) {
        this.idPersona = id;
    }

    @OneToMany(mappedBy = "personas")
    private Set<Tareas> tareas;
}
