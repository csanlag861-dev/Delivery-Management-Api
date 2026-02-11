package com.repartos.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "conductor")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conductorCodigo", nullable = false)
    private int codigo;

    @Column(name = "nombreYapellidos", nullable = false)
    private String nombre;

    @Column(name = "activo", nullable = true)
    private Boolean activo;

    // Constructores

    public Conductor(){}

    public Conductor(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Conductor (String nombre){
        this.nombre = nombre;
        this.activo = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
