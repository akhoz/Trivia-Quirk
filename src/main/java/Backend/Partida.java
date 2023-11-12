package Backend;

import Backend.Preguntas.Pregunta;

import java.util.ArrayList;
public class Partida {

    private int numeroPartida;
    private final ArrayList<Integer> preguntasRealizadas;
    private final ArrayList<Jugador> jugadores;

    public Partida(int numeroPartida){
        this.numeroPartida = numeroPartida;
        this.preguntasRealizadas = new ArrayList<Integer>();
        this.jugadores = new ArrayList<>();
    }

    public int getNumeroPartida(){
        return this.numeroPartida;
    }

    public ArrayList<Integer> getPreguntasRealizadas(){
        return this.preguntasRealizadas;
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public String toString(){
        return String.format("Partida %d", this.numeroPartida, this.preguntasRealizadas, this.jugadores);
    }

}
