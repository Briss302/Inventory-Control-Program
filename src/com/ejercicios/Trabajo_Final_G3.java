import java.util.LinkedList;
import java.util.Scanner;
public class Trabajo_Final_G3 {
    final static int DATOS = 12;
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
        String codigoEquipo = lecturaCodigo("eliminar");

    }

    private static String lecturaCodigo(String eliminar) {
        return "X";
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
        String respuesta = "";

        do {
            LinkedList equipo = new LinkedList();
            for (int i = 0; i < DATOS-2; i++) {
                System.out.print("Ingresar " + datos[i] + ":");
                equipo.add(lector.next());
            }
            equipo.add("Operativo");    //Estado del equipo
            equipo.add(1);              //Estado de calibración. 1: Calibrado. 0: Descalibrado.

            listaEquipos.add(equipo);

            System.out.print("¿Desea ingresar otro equipo? (S/N): ");
            respuesta = lector.next().toUpperCase();
        } while (respuesta.equals("S"));

    }

    private static void crearInterfase() {
        System.out.println("-------------------------------------------");
        System.out.println("-----------INVENTARIO DE EQUIPOS-----------");
        System.out.println("-------------------------------------------");
        System.out.println("--- Opciones disponibles:               ---");
        System.out.println("--- 1. Ingreso de nuevo equipo.         ---");
        System.out.println("--- 2. Salida de equipo a campo.        ---");
        System.out.println("--- 3. Retorno de equipo desde campo.   ---");
        System.out.println("--- 4. Enviar equipo a mantenimiento.   ---");
        System.out.println("--- 5. Consulta de disponibilidad.      ---");
        System.out.println("--- 6. Eliminar equipo.                 ---");
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
}
