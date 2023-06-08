package com.proyecto1.service.entrenador;

import java.util.List;

import com.proyecto1.domain.Entrenador;

public interface EntrenadorService {
    public void crearEntrenador(String nombre, String apellido, int edad);
    public void eliminarEntrenador(Entrenador entrenador);

    public Entrenador buscarEntrenadorPorNombre(String nombre);

    public List<Entrenador> getEntrenadores();
}
