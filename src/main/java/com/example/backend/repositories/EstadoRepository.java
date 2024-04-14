package com.example.backend.repositories;

import com.example.backend.entities.Estados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estados, Integer> {
}
