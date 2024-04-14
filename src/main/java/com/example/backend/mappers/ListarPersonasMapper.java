package com.example.backend.mappers;

import com.example.backend.dto.response.ListarPersonasResponse;
import com.example.backend.entities.Personas;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ListarPersonasMapper implements Function<Personas, ListarPersonasResponse> {

    @Override
    public ListarPersonasResponse apply(Personas personas) {
        return ListarPersonasResponse.builder()
                .idPersona(personas.getIdPersona())
                .nombre(personas.getNombre())
                .codigo(personas.getCodigo())
                .build();
    }
}
