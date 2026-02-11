package com.repartos.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repartos.demo.entities.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {
    List<Conductor> findByActivo(Boolean activo);
    List<Conductor> findByNombre(String nombre);
    Conductor findByCodigo(int codigo);
}
