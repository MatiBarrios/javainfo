package com.proyecto1.domain;

import com.proyecto1.enums.Posicion;

public class Jugador {

    private String nombre;
    private String apellido;
    private double altura;
    private int posicion;
    private int goles;
    private int partidos;
    private boolean Capitan;
    private int numeroCamiseta;
    private Equipo equipo;

    public Jugador(
        String nombre, String apellido, 
        double altura, int posicion, 
        int goles, int partidos, boolean Capitan,
        int numeroCamiseta, Equipo equipo
        ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.posicion = posicion;
        this.goles = goles;
        this.partidos = partidos;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;
        this.Capitan = Capitan;
    }

    // Has encontrado el comentario EasterEgg

    public boolean isCapitan() {
        return Capitan;
    }

    public void setCapitan(boolean Capitan) {
        this.Capitan = !this.Capitan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Posicion getPosicion() {
        return Posicion.values()[posicion];
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", altura=" + altura + ", posicion=" + posicion
                + ", goles=" + goles + ", partidos=" + partidos + ", Capitan=" + Capitan + ", numeroCamiseta="
                + numeroCamiseta + ", equipo=" + equipo.getNombre() + "]";
    }

    // Hola profe :D
}
