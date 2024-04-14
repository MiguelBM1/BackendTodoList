package com.example.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListarTareaResponse {

    private int id;
    private String nombre;
    private String descripcion;
    private String fechaFinalizacion;
    private String estado;
    private String persona;
    private String codigo;
    private String departamento;
    private String idEstado;
    private String idPersona;


}
