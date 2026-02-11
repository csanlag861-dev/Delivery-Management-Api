package com.repartos.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.repartos.demo.entities.Conductor;
import com.repartos.demo.entities.Distribuidora;
import com.repartos.demo.entities.Reparto;
import com.repartos.demo.entities.Producto;
import com.repartos.demo.repositories.ConductorRepository;
import com.repartos.demo.repositories.DistribuidoraRepository;
import com.repartos.demo.repositories.ProductoRepository;
import com.repartos.demo.repositories.RepartoRepository;

@Service
public class RepartoServices {
    private final RepartoRepository repartoRepository;
    private final ConductorRepository conductorRepository;
    private final ProductoRepository productoRepository;
    private final DistribuidoraRepository distribuidoraRepository;

    public RepartoServices(RepartoRepository repartoRepository, ConductorRepository conductorRepository,
            ProductoRepository productoRepository, DistribuidoraRepository distribuidoraRepository) {
        this.repartoRepository = repartoRepository;
        this.conductorRepository = conductorRepository;
        this.productoRepository = productoRepository;
        this.distribuidoraRepository = distribuidoraRepository;
    }

    public Reparto crearRepartoPendiente(int conductorCodigo, int distribuidoraCodigo, Producto producto) {
        Conductor conductor = conductorRepository.findByCodigo(conductorCodigo);
        List<Conductor> conductores = repartoRepository.findByEstado("Transito").stream().map(c -> c.getConductor())
                .toList();
        Reparto reparto = null;
        if (conductor == null) {
            System.out.println("El conductor no existe.");
            throw new IllegalArgumentException("El conductor no existe.");
        } else {
            if (conductores.contains(conductor)) {
                throw new IllegalArgumentException("El conductor ya está en tránsito.");
            } else {
                if (!conductor.getActivo()) {
                    System.out.println("El conductor no está disponible.");
                    throw new IllegalArgumentException("El conductor no está disponible.");
                } else {
                    Producto productoBuscado = productoRepository.findByCodigo(producto.getCodigo()).getFirst();
                    if (productoBuscado == null) {
                        System.out.println("No existe un producto con ese código.");
                        throw new IllegalArgumentException("No existe un producto con ese código.");
                    } else {
                        Distribuidora distribuidora = distribuidoraRepository.findByCodigo(distribuidoraCodigo);
                        if (distribuidora == null) {
                            System.out.println("No existe la distribuidora con ese código.");
                            throw new IllegalArgumentException("No existe la distribuidora con ese código.");
                        } else {
                            reparto = repartoRepository
                                    .save(new Reparto(conductor, producto, "Pendiente", distribuidora));
                        }
                    }
                }
            }
        }
        return repartoRepository.save(reparto);
    }

    public Reparto crearRepartoPrioritario(int conductorCodigo, int distribuidoraCodigo, Producto producto) {
        Conductor conductor = conductorRepository.findByCodigo(conductorCodigo);
        List<Conductor> conductores = repartoRepository.findByEstado("Transito").stream().map(c -> c.getConductor())
                .toList();
        Reparto reparto = null;
        if (conductor == null) {
            System.out.println("El conductor no existe.");
        } else {
            if (conductores.contains(conductor)) {
                throw new IllegalArgumentException("El conductor ya está en tránsito.");
            } else {
                if (!conductor.getActivo()) {
                    System.out.println("El conductor no está disponible.");
                    throw new IllegalArgumentException("El conductor no está disponible.");
                } else {
                    Producto productoBuscado = productoRepository.findByCodigo(producto.getCodigo()).getFirst();
                    if (productoBuscado == null) {
                        System.out.println("No existe un producto con ese código.");
                        throw new IllegalArgumentException("No existe un producto con ese código.");
                    } else {
                        Distribuidora distribuidora = distribuidoraRepository.findByCodigo(distribuidoraCodigo);
                        if (distribuidora == null) {
                            System.out.println("No existe una distribuidora con ese código.");
                            throw new IllegalArgumentException("No existe una distribuidora con ese código.");
                        } else {

                            reparto = repartoRepository
                                    .save(new Reparto(conductor, producto, "Prioritario", distribuidora));
                        }
                    }
                }
            }
        }
        return repartoRepository.save(reparto);
    }

    public Reparto crearRepartoTransito(int repartoCodigo) {
        Reparto reparto = repartoRepository.findByCodigo(repartoCodigo).getFirst();
        if (reparto == null) {
            System.out.println("No existe un reparto con ese código.");
        } else {
            List<Reparto> repartos = repartoRepository.findByEstado("Prioritario");
            System.out.println(repartos);
            if (!repartos.isEmpty()) {
                if (!repartos.contains(reparto)) {
                    System.out.println("El reparto no está en estado Prioritario.");
                    throw new IllegalArgumentException("El reparto no está en estado Prioritario.");
                } else {
                    reparto.setEstado("Transito");
                }
            } else {
                reparto.setEstado("Transito");
            }

        }
        return repartoRepository.save(reparto);
    }

    public Reparto crearRepartoFinalizado(int repartoCodigo) {
        Reparto reparto = repartoRepository.findByCodigo(repartoCodigo).getFirst();
        if (reparto == null) {
            System.out.println("No existe un reparto con ese código.");
            throw new IllegalArgumentException("El reparto no existe.");
        } else {
            List<Reparto> repartos = repartoRepository.findByEstado("Transito");
            System.out.println(repartos);
            if (!repartos.contains(reparto)) {
                System.out.println("El reparto no está en estado Transito.");
                throw new IllegalArgumentException("El reparto no está en estado Transito.");
            } else {
                reparto.setEstado("Finalizado");
            }
        }
        return repartoRepository.save(reparto);
    }
}
