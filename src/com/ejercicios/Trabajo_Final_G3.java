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
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            if (!listaEquipos.isEmpty()) {  //Este if evita que se vea error al estar la lista vacía
                int equipo = lecturaCodigo("eliminar");

                if (equipo == -2) break;    //Si el usuario seleccionó SALIR en lecturaCodigo()
                listaEquipos.remove(equipo);

                System.out.print("¿Desea eliminar otro equipo? (S/N): ");
                respuesta = lector.nextLine().toUpperCase();
            }
            else break;
        } while (respuesta.equals("S"));
    }

    private static int lecturaCodigo(String descripción) {
        Scanner lector = new Scanner(System.in);

        int equipo; //variable que almacenará el índice del equipo al que le corresponde el código que ingresó el usuario
        do {
            System.out.print("Ingresar el código del equipo a " + descripción + " (caso contrario escriba SALIR): ");
            String codigo = lector.nextLine().toUpperCase();

            if (codigo.equals("SALIR")) return -2;
            equipo = buscarEquipo(1, codigo);
        } while (equipo < 0); //Si el equipo no existe o si el usuario ingresó mal el código, el método buscarEquipo devolverá -1, por lo que se repetirá el ciclo y se volverá a pedir el código al usuario

        return equipo;
    }

    private static int buscarEquipo(int propiedad, String etiqueta) { //Busca el índice del equipo que tiene la etiqueta respectiva en su propiedad respectiva
        int n = 0;
        LinkedList equipo = new LinkedList<>();
        String propEquipo;

        while (true){
            try{
                equipo = (LinkedList) listaEquipos.get(n);
                propEquipo = (String) equipo.get(propiedad);
            } catch (Exception e) {
                return n = -1;
            }
            if (!propEquipo.equals(null)) {
                    if (propEquipo.equals((String) etiqueta)) return n;
                    else {
                        n++;
                }
            }
            else return n = -1;
        }
    }

    private static void disponibilidadTipo() { //Jonathan
        System.out.println("disponibilidadTipo");
    }

    private static void disponibilidadEquipo() {
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            if (!listaEquipos.isEmpty()) {
                boolean test = true;
                LinkedList equipoDisponibilidad = new LinkedList<>(); //Valor por defecto

                int equipo = lecturaCodigo("consultar disponibilidad");

                if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                equipoDisponibilidad = (LinkedList) listaEquipos.get(equipo);

                String status = (String) equipoDisponibilidad.get(DATOS-2);
                String ubicacion = (String) equipoDisponibilidad.get(DATOS-3);
                int calibracion = (int) equipoDisponibilidad.get(DATOS-1);

                System.out.println("El estado actual del equipo es: " + status + ".");
                System.out.println("Su ubicación actual es: " + ubicacion + ".");
                if (calibracion == 1) System.out.println("El equipo está calibrado.");
                else System.out.println("El equipo necesita calibración.");

                System.out.print("¿Desea consultar por otro equipo? (S/N): ");
                respuesta = lector.next().toUpperCase();
            }
            else break;
        } while(respuesta.equals("S"));
    }

    private static void mantenimiento() {
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            if (!listaEquipos.isEmpty()) {
                boolean test = true;
                LinkedList equipoMantenimiento = new LinkedList<>(); //Valor por defecto
                int equipo = -2;
                do {
                    equipo = lecturaCodigo("llevar a mantenimiento");

                    if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                    equipoMantenimiento = (LinkedList) listaEquipos.get(equipo);
                    if (equipoMantenimiento.get(DATOS-2).equals("En campo")) System.out.println("El equipo se encuentra en campo");
                    else if (equipoMantenimiento.get(DATOS-2).equals("En mantenimiento")) System.out.println("El equipo ya se encuentra en mantenimiento");
                    else test = false;
                }while (test);

                if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                equipoMantenimiento.set(DATOS-2,"En mantenimiento");

                System.out.println("Ingrese el lugar del mantenimiento: ");
                equipoMantenimiento.set(DATOS - 3, lector.next()); //Cambiando la ubicación del equipo al lugar del mantenimiento
                listaEquipos.set(equipo, equipoMantenimiento);

                System.out.println(listaEquipos); //DEBUG
                System.out.print("¿Desea dar mantenimiento a otro equipo? (S/N): ");
                respuesta = lector.next().toUpperCase();
            }
            else break;
        } while(respuesta.equals("S"));
    }

    private static void retornoEquipo() {
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            if (!listaEquipos.isEmpty()) {
                boolean test = true;
                LinkedList equipoARetornar = new LinkedList<>(); //Valor por defecto
                int equipo = -1;    //Valor por defecto

                do {
                    equipo = lecturaCodigo("retornar");

                    if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                    equipoARetornar = (LinkedList) listaEquipos.get(equipo);

                    if (equipoARetornar.get(DATOS-2).equals("Operativo")) System.out.println("El equipo se encuentra con estado Operativo, no está en campo o en otra ubicación.");
                    else if (equipoARetornar.get(DATOS-2).equals("Inoperativo")) System.out.println("El equipo se encuentra Inoperativo, envíelo a mantenimiento");
                    else test = false;
                }while (test);

                if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                System.out.println("¿El equipo retorna en buen estado? (S/N): ");
                if (lector.next().toUpperCase().equals("S")) equipoARetornar.set(DATOS-2,"Operativo");
                else equipoARetornar.set(DATOS-2,"Inoperativo");

                System.out.println("¿El equipo retorna calibrado? (S/N): ");
                if (lector.next().toUpperCase().equals("S")) equipoARetornar.set(DATOS-1,1);
                else equipoARetornar.set(DATOS-1,0);

                System.out.print("Ingrese la nueva ubicación del equipo: ");
                equipoARetornar.set(DATOS - 3, lector.next()); //Cambiando la ubicación del equipo
                listaEquipos.set(equipo, equipoARetornar);

                System.out.println(listaEquipos); //DEBUG
                System.out.print("¿Desea retornar otro equipo? (S/N): ");
                respuesta = lector.next().toUpperCase();
            }
            else break;
        } while(respuesta.equals("S"));
    }

    private static void salidaEquipo() {
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            if (!listaEquipos.isEmpty()) {
                int equipo = lecturaCodigo("llevar a campo");

                if (equipo == -2) break; //Si el usuario seleccionó SALIR en lecturaCodigo()

                LinkedList equipoASalir = (LinkedList) listaEquipos.get(equipo);
                String status = (String) equipoASalir.get(DATOS-2);
                int calibracion = (int) equipoASalir.get(DATOS-1);

                if (status.equals("Operativo")) {
                    if (calibracion == 1) {
                        equipoASalir.set(DATOS - 2, "En campo");   //Cambiando el estado del equipo

                        System.out.print("Ingrese la nueva ubicación del equipo: ");
                        equipoASalir.set(DATOS - 3, lector.next()); //Cambiando la ubicación del equipo
                        listaEquipos.set(equipo, equipoASalir);

                        System.out.println(listaEquipos);//DEBUG
                    } else {
                        System.out.println("El equipo está descalibrado.");
                    }
                } else {
                    System.out.println("El equipo se encuentra " + status + ".");
                }

                System.out.print("¿Desea sacar otro equipo? (S/N): ");
                respuesta = lector.next().toUpperCase();
            }
            else break;
        } while(respuesta.equals("S"));
    }

    private static void ingresoEquipo() {
        System.out.println("ingresoEquipo");
        Scanner lector = new Scanner(System.in);
        String respuesta = "";

        do {
            LinkedList equipo = new LinkedList();
            for (int i = 0; i < DATOS-2; i++) {
                System.out.print("Ingresar " + datos[i] + ":");
                equipo.add(lector.nextLine());
            }
            equipo.add("Operativo");    //Estado del equipo
            equipo.add(1);              //Estado de calibración. 1: Calibrado. 0: Descalibrado.

            listaEquipos.add(equipo);

            System.out.print("¿Desea ingresar otro equipo? (S/N): ");
            respuesta = lector.nextLine().toUpperCase();
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
        System.out.println("--- 7. Visualizar equipos.              ---");
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
}
