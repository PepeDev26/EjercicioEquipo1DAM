/**
 * Esta clase...
 *
 * @Author: Manuel Sánchez Alcántara y Adrián Suárez Valdayo subido al Git por PepeDev26
 * @Version: 2024.03
 */
public class Equipo {

//    Constantes
    private final static int JUGADORES = 5;

//    Atributos
    private String nombre; //Nombre del equipo
    private String categoria; //División del equipo
    private Jugador[] jugadores; //Jugadores del equipo

    private int cont; //Contador de jugadores



    public Equipo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.jugadores = new Jugador[JUGADORES];
        this.cont = 0;
    }


//    Getter y Setter

    public int getCont() {
        return cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

//    Metodos

    /**
     * Metodo para crear jugadores.
     * @param juga parámetro de tipo "jugador".
     */
    public void altaJugadores(Jugador juga){
        if (this.cont < JUGADORES) {// Si el contador supera el tamaño del vector dará un mensaje de error.
            this.jugadores[this.cont] = juga;
            this.cont++;
        } else {
            System.out.println("Error. No se puede dar de alta más jugadores.");
        }
    }

    /**
     * Mostramos el nombre y apellido de todos los jugadores dado de alta del equipo.
     */
    public void mostrarJugadores(){
        for (int i = 0; i < this.cont; i++) {
            System.out.println(i + " " + this.jugadores[i].getNombre() + " " + this.jugadores[i].getApellido());
        }
    }

    /**
     * Comprueba si el dorsal introducido ya existe
     * @param dorsal
     * @return true si el dorsal existe y false en caso contrario
     */
    public boolean verDorsal(int dorsal){
        boolean b = false;
        for(int i=0; i < this.cont; i++){
            if(this.jugadores[i].getDorsal() == dorsal){
                b = true;
                break;
            }
        }
        return b;
    }
    public void mgJugador(int pos){
        this.jugadores[pos].mejorDelPartido();
    }
}
