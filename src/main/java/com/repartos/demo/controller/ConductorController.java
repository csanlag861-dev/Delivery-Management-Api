package com.repartos.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.repartos.demo.entities.Conductor;
import com.repartos.demo.repositories.ConductorRepository;
import com.repartos.demo.services.ConductorServices;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ConductorController {
    // Atributos para el contexto
    private ConductorRepository conductorRepository;
    private ConductorServices conductorServices;

    public ConductorController(ConductorRepository conductorRepository, ConductorServices conductorServices) {
        this.conductorRepository = conductorRepository;
        this.conductorServices = conductorServices;
    }

    @GetMapping("/Distribuidora/Conductores/TodosConductores")
    // Devuelve todos los conductores que hay en la Distribuidora.
    public ResponseEntity<List<Conductor>> FindAll() {
        // Cargamos los posibles conductores que traemos a través del Repositorio.
        Optional<List<Conductor>> conductores = Optional.of(conductorRepository.findAll());
        List<Conductor> listaConductores = new ArrayList<>();

        // Si hay conductores:
        if (conductores.isPresent()) {
            for (Conductor c : conductores.get()) {
                listaConductores.add(c);
            }
            if (listaConductores.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(listaConductores);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("Distribuidora/Conductores/DescansoConductor")
    public ResponseEntity<?> descansoConductor(@RequestParam("conductorCodigo") int conductorCodigo) {
        try {
            conductorServices.descansoConductor(conductorCodigo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
