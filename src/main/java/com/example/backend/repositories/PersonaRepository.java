package com.example.backend.repositories;

import com.example.backend.entities.Personas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Personas, Integer> {
}
