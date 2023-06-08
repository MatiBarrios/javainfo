package com.proyecto1.domain;

import java.sql.Date;

public class Equipo {
    @Override
    public String toString() {
        return "Equipo [nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", entrenador=" + entrenador
                + "]";
    }

    private String nombre;
    private Date fechaCreacion;
    private Entrenador entrenador;

    public Equipo(String nombre, Date fechaCreacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

}
