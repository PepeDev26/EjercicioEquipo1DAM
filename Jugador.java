/**
 * Esta clase registra la info de los jugadores que habrá dentro del equipo
 *
 * @Author: Manuel Sánchez Alcántara feat. Javier Valladolid subido al Git por PepeDev26
 * @Version: 2024.03
 */
public class Jugador
{
    // atributos
    private String nombre, apellido;
    private int dorsal; //Dorsal del jugador
    private int mvp; //Nº de veces que ha sido mejor del partido
    private int pjugados; //Nº de partidos jugados
    private double km; //Km recorridos en un partido

    // constructor
    public Jugador(String nombre, String apellido, int dorsal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.mvp = 0;
        this.pjugados = 0;
        this.km = 0;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getMvp() {
        return mvp;
    }

    public void setMvp(int mvp) {
        this.mvp = mvp;
    }

    public int getPjugados() {
        return pjugados;
    }

    public void setPjugados(int pjugados) {
        this.pjugados = pjugados;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    // metodos

    /**
     *
     * Aumenta en 1 las veces que se es el mejor del partido
     * @return void
     */
    public void mejorDelPartido(){
        this.mvp++;
    }

    /**
     *
     * @param km
     */
    public void meterRecorrido(double km){
        this.km += km;
        this.pjugados++;
    }

    /**
     *
     * Calcula la media de km recorridos por partido
     * @return double
     */
    public double mediaRecorrido(){
        double d = 0.0;
        if (this.pjugados != 0){
            d = this.km / (double) this.pjugados;
        }
        return d;
    }

    /**
     * Devuelve la información del jugador
     * @return String nombre, apellido, media de km y veces Mejor Jugador
     */
    @java.lang.Override
    public String toString() {
        return this.nombre+" "+this.apellido+" | "+this.mediaRecorrido()+" | "+this.mvp;
    }


}
