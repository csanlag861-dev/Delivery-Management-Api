package com.repartos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repartos.demo.entities.Conductor;
import com.repartos.demo.entities.Reparto;
import java.util.List;


@Repository
public interface RepartoRepository extends JpaRepository<Reparto, Integer> {
    List<Reparto> findByCodigo(int codigo);
    List<Reparto> findByEstado(String estado);
    List<Reparto> findByConductor(Conductor conductor);
}
