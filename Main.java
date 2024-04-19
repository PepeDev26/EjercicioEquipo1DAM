import java.util.Scanner;

/**
 * Esta clase...
 *
 * @Author: Manuel Sánchez Alcántara subido al Git por PepeDev26
 * @Version: 2024.03
 */

public class Main {
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {

        final int N = 3;
        int op;
        Equipo[] equipos = new Equipo[N];
        int indice = 0;

        do {
            System.out.printf("1.- Dar de alta un equipo\n" +
                    "2.- Dar de alta a jugadores en un equipo\n" +
                    "3.- Mostrar jugadores por equipo\n" +
                    "4.- Marcar jugador como mejor del partido\n" +
                    "5.- Añadir kilometros recorridos a jugadores\n" +
                    "6.- Mostrar todos los jugadores federados\n" +
                    "7.- Salir\n");

            op = sn.nextInt();


            switch (op) {
                case 1:
                    if (indice < N) {
                        equipos[indice] = altaEquipo();
                        indice++;
                    } else {
                        System.out.println("error, todos los equipos se han creado");
                    }
                    break;
                case 2:
                    if (indice > 0) {
                        altaJugadores(equipos, indice);
                    } else {
                        System.out.println("Error, aun no has introducido ningun equipo");
                    }
                    break;
                case 3:
                    if (indice > 0) {
                        mostrarJugadores(equipos, indice);
                    } else {
                        System.out.println("Error, aun no has introducido ningun equipo");
                    }
                    break;
                case 4: //Elegir mejor jugador del partido
                    if (indice > 0) {
                        mvp(equipos, indice);
                    } else {
                        System.out.println("Error, aun no has introducido ningun equipo");
                    }
                    break;
                case 5:
                    if (indice > 0) {
                        introducirKm(equipos, indice);
                    } else {
                        System.out.println("Error, aun no has introducido ningun equipo");
                    }
                    break;
                case 6:
                    if (indice > 0) {
                        listarJugadores(equipos, indice);
                    } else {
                        System.out.println("Error, aun no has introducido ningun equipo");
                    }
                    break;
                case 7:
                    break;
                default:
                    break;
            }


        } while (op != -1);

    }


    public static Equipo altaEquipo() {
        Equipo equipo;
        String categoria = "";
        String nombre;
        int op;

        System.out.println("Introduce el nombre del equipo");
        nombre = sn.nextLine();
        System.out.println("Indicame la categoría");
        do {
            op = sn.nextInt();
            switch (op) {
                case 1:
                    categoria = "1º División";
                    break;
                case 2:
                    categoria = "2º División";
                    break;
                case 3:
                    categoria = "3º División";
                    break;
                default:
                    System.out.println("No ha introducido la división correcta (1, 2 ó 3)");
                    break;
            }
        } while ((op != 1) || (op != 2) || (op != 3));
        equipo = new Equipo(nombre, categoria);
        return equipo;
    }

    public static void altaJugadores(Equipo[] equipo, int n) {
        String nombre;
        String apellidos;
        int dorsal;
        int iE = 0;

        do {
            System.out.printf("Hay %d equipos creados\n", n);
            System.out.print("Elige un equipo:");
            iE = sn.nextInt();
            iE--;
        } while (iE < 0 || iE >= n);

        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce el nombre: ");
            nombre = sn.nextLine();
            System.out.println("Introduce el apellido:");
            apellidos = sn.nextLine();
            do {
                System.out.println("Introduce el dorsal: ");
                dorsal = sn.nextInt();
                if (equipo[iE].verDorsal(dorsal)) {
                    System.out.println("Error, el dorsal ya existe.");
                }
            } while (equipo[iE].verDorsal(dorsal));
            equipo[iE].altaJugadores(new Jugador(nombre, apellidos, dorsal));
        }
    }

    /**
     * @param equipo vector que almacena los equipos participantes en la liga.
     * @param n      indica cuantos equipos tenemos en la liga.
     */
    public static void mostrarJugadores(Equipo[] equipo, int n) {
        int num = elegirEquipo(equipo, n); // nuemro del equio

        equipo[num].mostrarJugadores();
    }

    public static void mvp(Equipo[] equipo, int n) {
        int num;
        int num2;
        num = elegirEquipo(equipo, n);

        if (equipo[num].getCont() == 0) {
            System.out.println("El equipo está vacio");
        } else {
            equipo[num].mostrarJugadores();
            System.out.println();
            do {
                System.out.println("Elige el número del  jugador");
                num2 = sn.nextInt();
            } while ((num2 < 0) || (num2 >= equipo[num].getCont()));
            equipo[num].mgJugador(num2);
        }
    }

    public static void introducirKm(Equipo[] equipo, int n) {
        int num = elegirEquipo(equipo, n);
        int num2;
        double km;
        if (equipo[num].getCont() == 0) {
            System.out.println("El equipo está vacio");
        } else {
            System.out.println();
            for(Jugador jug : equipo[num].getJugadores()){
                if (jug != null){
                    System.out.println(jug.getNombre() + " " + jug.getApellido());
                    System.out.println("Introduce los KM recorridos: ");
                    km = sn.nextDouble();
                    jug.meterRecorrido(km);
                    System.out.println("Media de KM recorridos por partido: " + jug.mediaRecorrido() + " KM");
                } else {
                    break;
                }
            }
        }
    }

    public static int elegirEquipo(Equipo[] equipo, int n) {
        int num;
        System.out.println("Los equipos que hay es:");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + equipo[i].getNombre());
        }
        do {
            System.out.println("Elige el número del  equipo correspondiente");
            num = sn.nextInt();
        } while ((num < 0) || (num >= n));
        return num;
    }
    public static void listarJugadores(Equipo[] equipo, int n){

        for (int i = 0; i < n; i++) {
            for (Jugador jug : equipo[i].getJugadores()){
                if(jug != null){
                    System.out.println(equipo[i].getNombre() + " | " + jug);
                }else{
                    break;
                }
            }

        }
    }
}
