package com.example.backend.mappers;

import com.example.backend.dto.response.ListarEstadoResponse;
import com.example.backend.entities.Estados;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ListarEstadoMapper implements Function<Estados, ListarEstadoResponse> {

    @Override
    public ListarEstadoResponse apply(Estados estados) {
        return ListarEstadoResponse.builder()
                .idEstado(estados.getIdEstado())
                .nombre(estados.getNombre())
                .build();
    }
}
