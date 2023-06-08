package com.proyecto1.service.jugador.impl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto1.domain.Equipo;
import com.proyecto1.domain.Jugador;
import com.proyecto1.service.jugador.JugadorService;

public class JugadorServiceImpl implements JugadorService {

    private static List<Jugador> jugadores = new ArrayList<>();

    @Override
    public void crearJugador(String nombre, String apellido, double altura, int posicion, 
                            int goles, int partidos, boolean Capitan,
                            int numeroCamiseta, Equipo equipo) {
        Jugador jugador = new Jugador(nombre, apellido, altura, posicion,
                                    goles, partidos, Capitan, 
                                    numeroCamiseta, equipo);
        jugadores.add(jugador);
    }

    @Override
    public Jugador getCapitan(Equipo equipo) {
        for (Jugador jugador : jugadores){
            if (jugador.getEquipo().equals(equipo) && jugador.isCapitan()) return jugador;   
        }
        return null;
    }

    @Override
    public Jugador buscarJugadorPorNombre(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().toLowerCase().contains(nombre.toLowerCase()) || jugador.getApellido().toLowerCase().contains(nombre.toLowerCase())) {
                return jugador;
            }
        }
        return null;
    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    @Override
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public List<Jugador> getJugadoresEquipo(Equipo equipo) {
        List<Jugador> listaJugadores = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getEquipo().equals(equipo)) {
                listaJugadores.add(jugador);
            }
        }
        return listaJugadores;
    }

    @Override
    public void mostrarDatosJugador(Jugador jugador) {
        System.out.println(jugador.toString());
    }

    @Override
    public List<Jugador> filtrarJugadoresNombre(String nombre) {
        List<Jugador> jugadors = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().toLowerCase().contains(nombre.toLowerCase()) || jugador.getApellido().toLowerCase().contains(nombre.toLowerCase())) {
                jugadors.add(jugador);
            }
        }
        return jugadors;
    }
    
}
