package com.repartos.demo.services;

import org.springframework.stereotype.Service;

import com.repartos.demo.entities.Distribuidora;
import com.repartos.demo.repositories.DistribuidoraRepository;

@Service
public class DistribuidoraServices {
    private final DistribuidoraRepository distribuidoraRepository;

    public DistribuidoraServices(DistribuidoraRepository distribuidoraRepository) {
        this.distribuidoraRepository = distribuidoraRepository;
    }

    public Distribuidora mostrarInformacion(int codigoDistribuidora) {
        Distribuidora distribuidora = distribuidoraRepository.findByCodigo(codigoDistribuidora);
        if (distribuidora == null) {
            throw new IllegalArgumentException("La distribuidora no existe.");
        }
        return distribuidora;
    }
}
