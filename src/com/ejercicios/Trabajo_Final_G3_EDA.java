package com.ejercicios;

import java.util.LinkedList;
import java.util.Scanner;

public class Trabajo_Final_G3_EDA {
    /*public class equipo{
        private String Nombre;
        private String Codigo;
        private String Marca;
        private String Modelo;
        private String Serie;
        private String Tipo;
        private String FechaCalibracion;
        private String Sede;
        private String FechaIngreso;
        private String Ubicacion;
        private String Estado;
        private String Calibracion;

        public equipo(String Nombre, String Codigo, String Marca, String Modelo){
            Nombre = Nombre;
            Codigo = Codigo;
            Marca = Marca;
            Modelo = Modelo;
        }
    }*/

    final static int DATOS = 5;
    //public static LinkedList equipo = new LinkedList();
    //public static String[] equipo = new String[DATOS];
    public static LinkedList listaEquipos = new LinkedList();
    public static String[] datos = {"Nombre", "Código", "Marca", "Modelo", "Serie", "Tipo", "Fecha de calibración", "Sede", "Fecha de ingreso", "Ubicación", "Estado", "Calibración"};

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        crearInterfase();

        while (true) {
            System.out.print("Ingrese el número de la opción seleccionada: ");
            String opcion = lector.next();

            switch (opcion) {
                case "1":
                    ingresoEquipo();
                    break;
                case "2":
                    salidaEquipo();
                    break;
                case "3":
                    retornoEquipo();
                    break;
                case "4":
                    mantenimiento();
                    break;
                case "5":
                    String seleccion = "E";
                    System.out.print("¿Desea ver la disponibilidad de equipos (E) o tipo de equipos (T)?: ");
                    seleccion = lector.next().toUpperCase();
                    switch (seleccion) {
                        case "E":
                            disponibilidadEquipo();
                            break;
                        case "T":
                            disponibilidadTipo();
                            break;
                    }
                    break;
                case "6":
                    eliminarEquipo();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta.");
                    break;
            }
        }
    }

    private static void eliminarEquipo() { //Daniel
        System.out.println("eliminarEquipo");
    }

    private static void disponibilidadTipo() { //Jonathan
        System.out.println("disponibilidadTipo");
    }

    private static void disponibilidadEquipo() {
        System.out.println("disponibilidadEquipo");
    }

    private static void mantenimiento() {
        System.out.println("mantenimiento");
    }

    private static void retornoEquipo() {
        System.out.println("retornoEquipo");
    }

    private static void salidaEquipo() {
        System.out.println("salidaEquipo");
    }

    private static void ingresoEquipo() {
        System.out.println("ingresoEquipo");
        Scanner lector = new Scanner(System.in);

        for (int j = 0; j < 2; j++) {
            LinkedList equipo = new LinkedList();
            for (int i = 0; i < DATOS-2; i++) {
                System.out.print("Ingresar " + datos[i] + ":");
                equipo.add(lector.next());
            }
            listaEquipos.add(equipo);
        }

        LinkedList listaPrueba = new LinkedList<>();
        listaPrueba = (LinkedList) listaEquipos.get(0);
        System.out.println(listaPrueba.get(2));
        listaPrueba = (LinkedList) listaEquipos.get(1);
        System.out.println(listaPrueba.get(2));

    }

    private static void crearInterfase() {
        System.out.println("----------------------------------------");

    }
}

