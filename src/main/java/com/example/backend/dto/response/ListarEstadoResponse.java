package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListarEstadoResponse {

    private int idEstado;
    private String nombre;
}
