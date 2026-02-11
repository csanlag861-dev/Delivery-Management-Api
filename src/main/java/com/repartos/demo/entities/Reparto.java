package com.repartos.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "reparto")
public class Reparto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repartoCodigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "conductorCodigo", nullable = false)
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "productoCodigo", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "distribuidoraCodigo")
    @JsonBackReference
    private Distribuidora distribuidora;

    @Column(name = "estado", nullable = false)
    private String estado;

    public Reparto() {
    }

    public Reparto(Conductor conductor, Producto producto, String estado, Distribuidora distribuidora) {
        this.conductor = conductor;
        this.producto = producto;
        this.estado = estado;
        this.distribuidora = distribuidora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

}
