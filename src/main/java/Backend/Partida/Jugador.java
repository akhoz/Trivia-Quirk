package Backend.Partida;

import poo.proyecto2.triviaquirk.iJugador;
public class Jugador implements iJugador{

    private final String nombre;
    private short puntaje;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntaje = 0;
    }

    @Override
    public String obtenerNombreJugador() {
        return this.nombre;
    }

    @Override
    public short obtenerPuntaje() {
        return this.puntaje;
    }

    public short aumentarPuntaje(short puntos) {
        this.puntaje += puntos;
        return this.puntaje;
    }
}
