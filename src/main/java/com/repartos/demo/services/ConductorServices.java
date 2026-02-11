package com.repartos.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.repartos.demo.entities.Conductor;
import com.repartos.demo.entities.Reparto;
import com.repartos.demo.repositories.ConductorRepository;
import com.repartos.demo.repositories.RepartoRepository;

@Service
public class ConductorServices {
    private final RepartoRepository repartoRepository;
    private final ConductorRepository conductorRepository;

    public ConductorServices(RepartoRepository repartoRepository, ConductorRepository conductorRepository) {
        this.repartoRepository = repartoRepository;
        this.conductorRepository = conductorRepository;
    }

    public void descansoConductor(int conductorCodigo) {
        Conductor conductor = conductorRepository.findByCodigo(conductorCodigo);
        List<Reparto> repartosConductor = repartoRepository.findByConductor(conductor);
        int contador = 0;
        if (conductor == null) {
            System.out.println("El conductor no existe.");
            throw new IllegalArgumentException("El conductor no existe.");
        } else {
            for (Reparto reparto : repartosConductor) {
                if (reparto.getEstado() == "Finalizado") {
                    contador++;
                }
            }
            if (contador >= 3) {
                conductor.setActivo(false);
                conductorRepository.save(conductor);
            } else{
                System.out.println("EL conductor No ha finalizado los suficientes repartos.");
                throw new IllegalArgumentException("El conductor no ha finalizado los suficientes repartos");
            }
        }
    }
}
