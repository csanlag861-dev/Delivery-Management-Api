package com.repartos.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repartos.demo.entities.Producto;
import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    List<Producto> findByCodigo(int codigo);
}
