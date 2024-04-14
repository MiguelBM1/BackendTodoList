package com.example.backend.services;

import com.example.backend.dto.requests.CrearTareaRequest;
import com.example.backend.dto.requests.EditarTareaRequest;
import com.example.backend.dto.response.ListarEstadoResponse;
import com.example.backend.dto.response.ListarPersonasResponse;
import com.example.backend.dto.response.ListarTareaResponse;
import com.example.backend.entities.Personas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TareaService {


    List<ListarTareaResponse> obtenerTareas();
    ListarTareaResponse crearTareas(CrearTareaRequest request);

    ListarTareaResponse obtenerTarea(String id);

    ListarTareaResponse actualizarTareas(String id, EditarTareaRequest request);

    ListarTareaResponse actualizarEstadoTareas(String id);

    void eliminarTareas(String id);

    List<ListarPersonasResponse> obtenerPersonas();

    List<ListarEstadoResponse> obtenerEstados();
}
