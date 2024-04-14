package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "departamentos")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int idDepartamento;

    @Column (name = "nombre")
    private String nombre;

    public Departamentos(Integer id) {
        this.idDepartamento = id;
    }

    @OneToMany(mappedBy = "departamentos")
    private Set<Personas> personas;



}
