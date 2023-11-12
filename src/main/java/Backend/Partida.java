package Backend;

import Backend.Preguntas.Pregunta;

import java.util.ArrayList;
public class Partida {

    private final int numeroPartida;
    public final ArrayList<Pregunta> preguntasRealizadas;
    private final ArrayList<Jugador> jugadores;

    public Partida(int numeroPartida){
        this.numeroPartida = numeroPartida;
        this.preguntasRealizadas = new ArrayList<Pregunta>();
        this.jugadores = new ArrayList<>();
    }

    public int getNumeroPartida(){
        return this.numeroPartida;
    }

    public ArrayList<Pregunta> getPreguntasRealizadas(){
        return this.preguntasRealizadas;
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void agregarPregunta(Pregunta pregunta){
        this.preguntasRealizadas.add(pregunta);
    }

    public String toString(){
        return String.format("Partida %d", this.numeroPartida, this.preguntasRealizadas, this.jugadores);
    }

}
