package Backend.Partida;

import Backend.Preguntas.Pregunta;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;
import poo.proyecto2.triviaquirk.iJugador;

import java.util.ArrayList;
public class Partida {

    private int numeroPartida;
    private final ArrayList<Integer> preguntasRealizadas;
    public final ArrayList<iSuscriptorPreguntas> listadoSuscriptores;
    private final ArrayList<iJugador> jugadores;

    public Partida(int numeroPartida){
        this.numeroPartida = numeroPartida;
        this.preguntasRealizadas = new ArrayList<Integer>();
        this.listadoSuscriptores = new ArrayList<iSuscriptorPreguntas>();
        this.jugadores = new ArrayList<>();
    }

    public int getNumeroPartida(){
        return this.numeroPartida;
    }

    public ArrayList<iSuscriptorPreguntas> getListadoSuscriptores() {
        return this.listadoSuscriptores;
    }
    public void addSuscriptor(iSuscriptorPreguntas suscriptor) {
        this.listadoSuscriptores.add(suscriptor);
    }
    public ArrayList<Integer> getPreguntasRealizadas(){
        return this.preguntasRealizadas;
    }

    public ArrayList<iJugador> getJugadores(){
        return this.jugadores;
    }

    public void agregarJugador(iJugador jugador){
        this.jugadores.add(jugador);
    }

    public String toString(){
        return String.format("Partida %d", this.numeroPartida, this.preguntasRealizadas, this.jugadores);
    }

}
