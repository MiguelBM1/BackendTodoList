package com.example.backend.repositories;

import com.example.backend.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tareas, Integer> {



}
