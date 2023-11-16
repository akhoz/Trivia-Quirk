package Backend.Partida;

import poo.proyecto2.triviaquirk.iJugador;

/**
 * Clase que representa a un jugador en el juego.
 */
public class Jugador implements iJugador {

    private final String nombre;
    private short puntaje;

    /**
     * Constructor de la clase Jugador.
     *
     * @param nombre el nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador
     */
    @Override
    public String obtenerNombreJugador() {
        return this.nombre;
    }

    /**
     * Obtiene el puntaje actual del jugador.
     *
     * @return el puntaje del jugador
     */
    @Override
    public short obtenerPuntaje() {
        return this.puntaje;
    }

    /**
     * Aumenta el puntaje del jugador en la cantidad especificada y muestra el puntaje actual.
     *
     * @param puntos la cantidad de puntos a aumentar
     * @return el nuevo puntaje del jugador
     */
    public short aumentarPuntaje(short puntos) {
        this.puntaje += puntos;
        System.out.println("Puntaje actual de " + this.nombre + ": " + puntaje);
        return this.puntaje;
    }
}
