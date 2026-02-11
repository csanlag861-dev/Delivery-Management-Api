package com.repartos.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repartos.demo.entities.Distribuidora;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Integer>{
    Distribuidora findByCodigo(int codigo);
}
