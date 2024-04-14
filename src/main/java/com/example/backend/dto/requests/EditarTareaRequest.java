package com.example.backend.dto.requests;

import com.example.backend.entities.Estados;
import com.example.backend.entities.Personas;
import com.example.backend.entities.Tareas;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditarTareaRequest {
    @NotEmpty(message = "El nombre de la tarea no puede estar vacío")
    @Max(value = 25, message = "El nombre de la tarea no puede tener más de 25 caracteres")
    private String nombre;

    @NotEmpty(message = "La descripción de la tarea no puede estar vacía")
    @Max(value = 250, message = "La descripción de la tarea no puede tener más de 250 caracteres")
    private String descripcion;

    @NotEmpty(message = "La fecha de finalización de la tarea no puede estar vacía")
    private String fechaFinalizacion;

    @NotEmpty(message = "El estado de la tarea no puede estar vacío")
    private String estado;

    @NotEmpty(message = "La persona de la tarea no puede estar vacía")
    private String persona;

    public Tareas toEntity(Integer id) {
        return Tareas.builder()
                .nombre(this.nombre)
                .descripcion(this.descripcion)
                .fechaFinalizacion(LocalDate.parse(this.fechaFinalizacion))
                .estados(new Estados(Integer.valueOf(this.estado)))
                .personas(new Personas(Integer.valueOf(this.persona)))
                .build();
    }
}
