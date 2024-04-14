package com.example.backend.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tareas")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Tareas {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private int idTarea;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_finalizacion")
    private LocalDate fechaFinalizacion;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id_estado")
    private Estados estados;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id_persona")
    private Personas personas;


}
