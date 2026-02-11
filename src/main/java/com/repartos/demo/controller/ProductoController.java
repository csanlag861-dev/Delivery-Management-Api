package com.repartos.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.repartos.demo.entities.Producto;
import com.repartos.demo.repositories.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductoController {
    // Atributos para el contexto
    private ProductoRepository productoRepository;

    public ProductoController (ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @GetMapping("Distribuidora/Productos/TodosProductos")
    // Devuelve los productos que hay en la distribuidora.
    public ResponseEntity<List<Producto>> FindAll() {
        Optional<List<Producto>> productos = Optional.of(productoRepository.findAll());
        List<Producto> listaProductos = new ArrayList<>();

        if (productos.isPresent()) {
            for (Producto p : productos.get()) {
                listaProductos.add(p);
            }

            if (listaProductos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(listaProductos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("Distribuidora/Productos/CrearProducto")
    // Crear un nuevo producto.
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        // Si no nos llega ningún código: 
        Producto nuevoProducto = productoRepository.save(producto);        
        return ResponseEntity.ok(nuevoProducto);
    }
    
    
}
