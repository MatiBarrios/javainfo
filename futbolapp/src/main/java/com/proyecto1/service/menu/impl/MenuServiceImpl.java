package com.proyecto1.service.menu.impl;

import java.util.Scanner;

import java.sql.Date;

import com.proyecto1.service.equipo.impl.EquipoServiceImpl;
import com.proyecto1.service.menu.MenuService;

public class MenuServiceImpl implements MenuService{


    private EquipoServiceImpl equipoService = new EquipoServiceImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        
        
        boolean salir = false;
        
        while (!salir) {
            System.out.println("Fut5App - Menú de opciones");
            System.out.println("1. Crear un Entrenador");
            System.out.println("2. Crear un equipo");
            System.out.println("3. Crear jugadores");
            System.out.println("4. Buscar jugador por nombre");
            System.out.println("5. Buscar equipo por nombre");
            System.out.println("6. Mostrar jugadores de un equipo");
            System.out.println("7. Eliminar un Equipo");
            System.out.println("8. Eliminar un Jugador");
            System.out.println("9. Importar lista de jugadores desde archivo");
            System.out.println("10. Exportar lista de jugadores a archivo");
            System.out.println("11. Mostrar nombres de los equipos disponibles");
            System.out.println("12. Mostrar nombres de los jugadores disponibles");
            System.out.println("13. Mostrar nombres de los entrenadores disponibles");
            System.out.println("14. Salir ");
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuCrearEntrenador();
                    break;
                case 2:
                    menuCrearEquipo();
                    break;
                case 3:
                    menuAgregarJugadorEquipo();
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del jugador a buscar: ");
                    equipoService.mostrarJugadoresPorNombre(sc.next());
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del Equipo a buscar: ");
                    equipoService.filtrarNombreEquipos(sc.next());
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del Equipo: ");
                    equipoService.mostrarJugadoresEquipo(equipoService.buscarEquipoPorNombre(sc.next()));
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del Equipo a Eliminar: ");
                    equipoService.eliminarEquipo(sc.next());
                    break;
                case 8:
                    System.out.print("ingrese nombre del jugador a eliminar:");
                    equipoService.eliminarJugador(sc.next());
                    break;
                    /*
                case 9:
                    equipoService.importarJugadoresDesdeArchivo(scanner);
                    break;
                case 10:
                    equipoService.exportarJugadoresAArchivo(scanner);
                    break;
                     */
                case 11:
                    equipoService.mostrarNombresEquipos();
                    break;
                case 12:
                    equipoService.mostrarJugadores();
                    break;
                case 13:
                    equipoService.mostrarEntrenadores();
                    break;
                case 14:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese nuevamente.");
                    break;
            }
        }
        sc.close();
    }
    public void menuCrearEntrenador(){
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombreEntrenador = sc.next();
        System.out.print("Ingrese el apellido del entrenador: ");
        String apellidoEntrenador = sc.next();
        System.out.print("Ingrese la edad del entrenador: ");
        int edadEntrenador = sc.nextInt();

        equipoService.crearEntrenador(nombreEntrenador,apellidoEntrenador,edadEntrenador);
    }
    
    private void menuCrearEquipo(){
        
        boolean EntrenadorExist=false;
        String nombreEntrenador="";

        while (EntrenadorExist){            
            System.out.print("Ingrese el nombre del entrenador: ");
            nombreEntrenador = sc.next();
            if (equipoService.buscarEntrenadorPorNombre(nombreEntrenador)!=null) EntrenadorExist=!EntrenadorExist;
            else System.out.println("no existe ningun entrenador con ese nombre, reintente porfavor");
        }
        System.out.println("------------------\n");
        
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = sc.next();
        System.out.print("Ingrese la fecha de creación del equipo: ");
        System.out.println("Ej: AAAA-MM-DD");
        String fechaCreacion = sc.next();

        equipoService.crearEquipo(nombreEquipo, Date.valueOf(fechaCreacion), nombreEntrenador);
        
        System.out.print("Equipo cargado con exito");
    }

    private void menuAgregarJugadorEquipo(){
        System.out.print("Ingrese el nombre del Equipo: ");
        String nombreEquipo = sc.next();
        
        if (equipoService.buscarEquipoPorNombre(nombreEquipo) != null){
            
            boolean cargarJugadores = true;

            while (cargarJugadores) {
                System.out.print("Ingrese el nombre del jugador: ");
                String nombreJugador = sc.next();
                System.out.print("Ingrese el apellido del jugador: ");
                String apellidoJugador = sc.next();
                System.out.print("Ingrese la altura del jugador: ");
                double alturaJugador = sc.nextDouble();
                System.out.println("Ingrese la posición del jugador (Mediocampista:0/Arquero:1/Defensor:2/Delantero:3): ");
                int posicionJugador = sc.nextInt();
                System.out.print("Ingrese la cantidad de goles del jugador: ");
                int golesJugador = sc.nextInt();
                System.out.print("Ingrese la cantidad de partidos del jugador: ");
                int partidosJugador = sc.nextInt();
                System.out.print("¿El jugador es capitán? (true/false): ");
                boolean Capitan = sc.nextBoolean();
                System.out.print("Ingrese el número de camiseta del jugador: ");
                int numeroCamiseta = sc.nextInt();

                equipoService.addJugadorEquipo( nombreJugador, apellidoJugador, alturaJugador, 
                                                posicionJugador, golesJugador, partidosJugador, 
                                                Capitan, numeroCamiseta, equipoService.buscarEquipoPorNombre(nombreEquipo));

                System.out.print("¿Desea cargar más jugadores para este equipo? (True/False): ");
                cargarJugadores = sc.nextBoolean();
            }
        }
        else{
            System.out.print("No existe ningun equipo con ese nombre");
        }
        
    }
}