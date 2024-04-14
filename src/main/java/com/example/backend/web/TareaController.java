package com.example.backend.web;

import com.example.backend.dto.requests.CrearTareaRequest;
import com.example.backend.dto.requests.EditarTareaRequest;
import com.example.backend.services.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @GetMapping("/personas")
    public ResponseEntity<?> getPersonas() {
        return ResponseEntity.ok(this.tareaService.obtenerPersonas());
    }

    @GetMapping("/estados")
    public ResponseEntity<?> getEstados() {
        return ResponseEntity.ok(this.tareaService.obtenerEstados());
    }
    @GetMapping
    public ResponseEntity<?> obtenerTareas() {
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTarea(@PathVariable String id) {
        return ResponseEntity.ok(tareaService.obtenerTarea(id));
    }

    @PostMapping
    public ResponseEntity<?> crearTarea(@RequestBody CrearTareaRequest request) {
        return ResponseEntity.ok(tareaService.crearTareas(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTarea(@PathVariable String id, @RequestBody EditarTareaRequest request) {
        return ResponseEntity.ok(tareaService.actualizarTareas(id, request));
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<?> actualizarEstadoTarea(@PathVariable String id) {
        return ResponseEntity.ok(tareaService.actualizarEstadoTareas(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTarea(@PathVariable String id) {
        tareaService.eliminarTareas(id);
        return ResponseEntity.noContent().build();
    }
    

}
