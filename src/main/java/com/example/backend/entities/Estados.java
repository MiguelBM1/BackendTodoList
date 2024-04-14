package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "estados")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Estados {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private int idEstado;

    @Column(name = "nombre")
    private String nombre;

    public Estados(Integer id) {
        this.idEstado = id;
    }

    @OneToMany(mappedBy = "estados")
    private Set<Tareas> tareas;


}
