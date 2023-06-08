package com.proyecto1.service.entrenador.impl;

import java.util.ArrayList;
import java.util.List;

import com.proyecto1.domain.Entrenador;
import com.proyecto1.service.entrenador.EntrenadorService;

public class EntrenadorServiceImpl implements EntrenadorService {

    private static List<Entrenador> entrenadores = new ArrayList<>();

    @Override
    public void crearEntrenador(String nombre, String apellido, int edad) {
        entrenadores.add(new Entrenador(nombre, apellido, edad));
    }

    @Override
    public Entrenador buscarEntrenadorPorNombre(String nombre) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getNombre().equalsIgnoreCase(nombre)) {
                return entrenador;
            }
        }
        return null;
    }

    @Override
    public void eliminarEntrenador(Entrenador entrenador) {
        entrenadores.remove(entrenador);
    }

    @Override
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

}