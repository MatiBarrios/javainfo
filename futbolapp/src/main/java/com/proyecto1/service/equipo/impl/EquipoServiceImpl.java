package com.proyecto1.service.equipo.impl;
import com.proyecto1.domain.Equipo;
import com.proyecto1.domain.Entrenador;
import com.proyecto1.service.entrenador.impl.EntrenadorServiceImpl;
import com.proyecto1.service.equipo.EquipoService;
import com.proyecto1.service.jugador.impl.JugadorServiceImpl;

import java.sql.Date;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class EquipoServiceImpl implements EquipoService {

    private static List<Equipo> equipos = new ArrayList<>();
    private static JugadorServiceImpl jugadorServiceImpl = new JugadorServiceImpl();
    private static EntrenadorServiceImpl entrenadorServiceImpl = new EntrenadorServiceImpl();
    
    @Override
    public void crearEquipo(String nombre, Date fechaCreacion, String nombreEntrenador) {
        equipos.add(new Equipo(nombre, fechaCreacion, entrenadorServiceImpl.buscarEntrenadorPorNombre(nombreEntrenador)));
    }

    @Override
    public Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) return equipo;
        }
        return null;
    }

    @Override
    public void mostrarJugadoresEquipo(Equipo equipo) {
        System.out.println(jugadorServiceImpl.getJugadoresEquipo(equipo).toString());
    }

    @Override
    public void eliminarEquipo(String nombre) {
        Iterator<Equipo> iterator = equipos.iterator();
        while (iterator.hasNext()) {
            Equipo equipo = iterator.next();
            if (equipo.getNombre().equals(nombre)) iterator.remove();
        }
    }

    @Override
    public List<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public Equipo buscarEntrenadorEquipo(Entrenador entrenador) {
        for (Equipo equipo : equipos) {
            if (equipo.getEntrenador().equals(entrenador)) return equipo;
        }
        return null;
    }

    @Override
    public void mostrarNombresEquipos() {
        for (Equipo equipo : equipos) System.out.println(equipo.getNombre());
    }

    @Override
    public void filtrarNombreEquipos(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().toLowerCase().contains(nombre.toLowerCase())) System.out.println(equipo.toString());
        }
    }

    @Override
    public void addJugadorEquipo(String nombre, String apellido, double altura, 
                                int posicion, int goles, int partidos, 
                                boolean Capitan, int numeroCamiseta, Equipo equipo) 
    {
        jugadorServiceImpl.crearJugador(nombre, apellido, altura, posicion, goles, partidos, Capitan, numeroCamiseta, equipo);
    }

    @Override
    public void eliminarJugador(String nombre) {
        jugadorServiceImpl.eliminarJugador(jugadorServiceImpl.buscarJugadorPorNombre(nombre));
    }

    @Override
    public void mostrarJugadoresPorNombre(String nombre) {
        System.out.println(jugadorServiceImpl.filtrarJugadoresNombre(nombre));
    }

    @Override
    public void mostrarJugadores() {
        System.out.println(jugadorServiceImpl.getJugadores().toString());
    }

    @Override
    public void mostrarEntrenadores() {
        System.out.println(entrenadorServiceImpl.getEntrenadores());
    }

    @Override
    public void crearEntrenador(String nombreEntrenador, String apellidoEntrenador, int edadEntrenador) {
        entrenadorServiceImpl.crearEntrenador(nombreEntrenador, apellidoEntrenador, edadEntrenador);
    }

    @Override
    public Entrenador buscarEntrenadorPorNombre(String Entrenadornombre) {
        return entrenadorServiceImpl.buscarEntrenadorPorNombre(Entrenadornombre);
    }
    
}