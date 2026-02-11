package com.repartos.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.repartos.demo.entities.Distribuidora;
import com.repartos.demo.repositories.DistribuidoraRepository;
import com.repartos.demo.services.DistribuidoraServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DistribuidoraController {
    private DistribuidoraServices dsitribuidoraServices;

    public DistribuidoraController(DistribuidoraServices distribuidoraServices) {
        this.dsitribuidoraServices = distribuidoraServices;
    }

    @GetMapping("Distribuidora/MostrarInformacion")
    public ResponseEntity<?> mostrarInformacion(@RequestParam("distribuidoraCodigo") int distribuidoraCodigo) {
        try {
            Distribuidora distribuidora = dsitribuidoraServices.mostrarInformacion(distribuidoraCodigo);
        return ResponseEntity.ok(distribuidora);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
