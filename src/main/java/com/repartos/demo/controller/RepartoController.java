package com.repartos.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.repartos.demo.entities.Producto;
import com.repartos.demo.entities.Reparto;
import com.repartos.demo.repositories.RepartoRepository;
import com.repartos.demo.services.RepartoServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RepartoController {
    RepartoRepository repartoRepository;
    RepartoServices repartoServices;

    public RepartoController(RepartoRepository repartoRepository, RepartoServices repartoServices) {
        this.repartoRepository = repartoRepository;
        this.repartoServices = repartoServices;
    }

    @PostMapping("Distribuidora/Repartos/DarAltaRepartoPendiente")
    public ResponseEntity<Reparto> altaRepartoPendiente(@RequestParam("conductorCodigo") int conductorCodigo,
            @RequestParam("distribuidoraCodigo") int distribuidoraCodigo, @RequestBody Producto producto) {
        Reparto repartoPendiente = repartoServices.crearRepartoPendiente(conductorCodigo, distribuidoraCodigo,
                producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repartoPendiente);
    }

    @PostMapping("Distribuidora/Repartos/RepartoPrioritario")
    public ResponseEntity<Reparto> altaRepartoPrioritario(@RequestParam("conductorCodigo") int conductorCodigo,
            @RequestParam("distribuidoraCodigo") int distribuidoraCodigo, @RequestBody Producto producto) {
        Reparto repartoPrioritario = repartoServices.crearRepartoPrioritario(conductorCodigo, distribuidoraCodigo,
                producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repartoPrioritario);
    }

    @PostMapping("Distribuidora/Repartos/RepartoTransito")
    public ResponseEntity<?> altaRepartoTransito(@RequestParam("repartoCodigo") int repartoCodigo) {
        try {
            Reparto repartoTransito = repartoServices.crearRepartoTransito(repartoCodigo);
            return ResponseEntity.status(HttpStatus.OK).body(repartoTransito);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.valueOf("El Reparto no es PRIORITARIO.")).body(e.getMessage());
        }
    }

    @PostMapping("Distribuidora/Repartos/RepartoFinalizado")
    public ResponseEntity<?> altaRepartoFinalizado(@RequestParam("repartoCodigo") int repartoCodigo) {
        try {
            Reparto repartoFinalizado = repartoServices.crearRepartoFinalizado(repartoCodigo);
            return ResponseEntity.status(HttpStatus.OK).body(repartoFinalizado);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.valueOf("El Reparto no es TRANSITO.")).body(e.getMessage());
        }
    }
    
}
