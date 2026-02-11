package com.repartos.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "distribuidora")
public class Distribuidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distribuidoraCodigo")
    private int codigo;

    @OneToMany
    @JoinColumn(name = "distribuidoraCodigo")
    private List<Conductor> conductores;

    @OneToMany
    @JoinColumn(name = "distribuidoraCodigo")
    private List<Producto> productos;

    @OneToMany (mappedBy = "distribuidora")
    @JsonManagedReference
    private List<Reparto> repartos;

    public Distribuidora (){}

    public Distribuidora(List<Conductor> conductores, List<Producto> productos) {
        this.conductores = conductores;
        this.productos = productos;
        this.repartos = new ArrayList<>();
    }

    public Distribuidora(List<Conductor> conductores, List<Producto> productos, List<Reparto> repartosPendientes,
            List<Reparto> repartosEnTransito, List<Reparto> repartosRealizados) {
        this.conductores = conductores;
        this.productos = productos;
        this.repartos = repartosPendientes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Reparto> getRepartos() {
        return repartos;
    }

    public void setRepartos(Reparto repartosPendientes) {
        this.repartos.add(repartosPendientes);
    }

}
