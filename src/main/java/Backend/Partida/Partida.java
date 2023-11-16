package Backend.Partida;

import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;
import poo.proyecto2.triviaquirk.iJugador;

import java.util.ArrayList;

/**
 * Clase que representa una partida en el juego.
 */
public class Partida {

    private int numeroPartida;
    private final ArrayList<Integer> preguntasRealizadas;
    public final ArrayList<iSuscriptorPreguntas> listadoSuscriptores;
    private final ArrayList<iJugador> jugadores;

    /**
     * Constructor de la clase Partida.
     *
     * @param numeroPartida el número de la partida
     */
    public Partida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
        this.preguntasRealizadas = new ArrayList<>();
        this.listadoSuscriptores = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    /**
     * Obtiene el número de la partida.
     *
     * @return el número de la partida
     */
    public int getNumeroPartida() {
        return this.numeroPartida;
    }

    /**
     * Obtiene la lista de suscriptores de la partida.
     *
     * @return la lista de suscriptores
     */
    public ArrayList<iSuscriptorPreguntas> getListadoSuscriptores() {
        return this.listadoSuscriptores;
    }

    /**
     * Agrega un suscriptor a la lista de suscriptores.
     *
     * @param suscriptor el suscriptor a agregar
     */
    public void addSuscriptor(iSuscriptorPreguntas suscriptor) {
        this.listadoSuscriptores.add(suscriptor);
    }

    /**
     * Obtiene la lista de preguntas realizadas en la partida.
     *
     * @return la lista de preguntas realizadas
     */
    public ArrayList<Integer> getPreguntasRealizadas() {
        return this.preguntasRealizadas;
    }

    /**
     * Obtiene la lista de jugadores de la partida.
     *
     * @return la lista de jugadores
     */
    public ArrayList<iJugador> getJugadores() {
        return this.jugadores;
    }

    /**
     * Obtiene la lista de nombres de los jugadores de la partida.
     *
     * @return la lista de nombres de jugadores
     */
    public ArrayList<String> getNombreJugadores() {
        ArrayList<String> nombreJugadores = new ArrayList<>();
        for (iJugador jugador : this.jugadores) {
            nombreJugadores.add(jugador.obtenerNombreJugador());
        }
        return nombreJugadores;
    }

    /**
     * Agrega un jugador a la lista de jugadores.
     *
     * @param jugador el jugador a agregar
     */
    public void agregarJugador(iJugador jugador) {
        this.jugadores.add(jugador);
    }

    /**
     * Retorna una representación en cadena de la partida.
     *
     * @return una cadena que representa la partida
     */
    public String toString() {
        return String.format("Partida %d", this.numeroPartida);
    }

    /**
     * Limpia la lista de preguntas realizadas en la partida.
     */
    public void limpiarPreguntasRealizadas() {
        this.preguntasRealizadas.clear();
    }
}
