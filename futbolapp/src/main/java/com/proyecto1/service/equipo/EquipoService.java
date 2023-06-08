package com.proyecto1.service.equipo;

import java.sql.Date;
import java.util.List;

import com.proyecto1.domain.Entrenador;
import com.proyecto1.domain.Equipo;

public interface EquipoService {

    public void eliminarEquipo(String nombre);
    public void eliminarJugador(String nombre);
    public void mostrarNombresEquipos();
    public void mostrarJugadores();
    public void mostrarEntrenadores();
    public void filtrarNombreEquipos(String nombre);

    public void crearEquipo(String nombre, Date fechaCreacion,String nombreEntrenador);
    public void crearEntrenador(String nombreEntrenador, String apellidoEntrenador, int edadEntrenador);
    public void addJugadorEquipo(String nombre, String apellido, double altura, int posicion, int goles, int partidos, boolean Capitan, int numeroCamiseta, Equipo equipo);
    public void mostrarJugadoresPorNombre(String nombre);

    public Equipo buscarEquipoPorNombre(String nombre);
    public Equipo buscarEntrenadorEquipo(Entrenador entrenador);
 

    public List<Equipo> getEquipos();
    public Entrenador buscarEntrenadorPorNombre(String nombre);
    public void mostrarJugadoresEquipo(Equipo equipo);

}