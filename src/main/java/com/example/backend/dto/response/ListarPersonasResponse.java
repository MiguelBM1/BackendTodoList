package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListarPersonasResponse {

        private int idPersona;
        private String nombre;
        private String codigo;
}
