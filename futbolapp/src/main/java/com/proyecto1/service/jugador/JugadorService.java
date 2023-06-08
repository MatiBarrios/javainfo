package com.proyecto1.service.jugador;

import java.util.List;

import com.proyecto1.domain.Equipo;
import com.proyecto1.domain.Jugador;

public interface JugadorService {
    public void crearJugador(String nombre, String apellido, double altura, int posicion, 
                            int goles, int partidos, boolean Capitan,
                            int numeroCamiseta, Equipo equipo);
    public Jugador getCapitan(Equipo equipo);
    public Jugador buscarJugadorPorNombre(String nombre);
    
    public void eliminarJugador(Jugador jugador);
    public void mostrarDatosJugador(Jugador jugador);
    public List<Jugador> filtrarJugadoresNombre(String jugador);

    public List<Jugador> getJugadores();
    public List<Jugador> getJugadoresEquipo(Equipo equipo);
}
