package Backend.Partida;

import Backend.Preguntas.*;
import Backend.Preguntas.Data.*;
import poo.proyecto2.triviaquirk.excepciones.excepcionPartidaNoDisponible;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.iCategorias;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La clase Categoria representa una categoría de preguntas en el juego Trivia Quirk.
 * Cada instancia de esta clase se encarga de gestionar las partidas activas, las preguntas
 * relacionadas con la categoría y proporcionar funcionalidades para la interacción con los jugadores
 * y los suscriptores de preguntas.
 */
public class Categoria implements iCategorias {

    /** El nombre de la categoría. */
    private String nombre;

    /** Lista de partidas activas en la categoría. */
    private final ArrayList<Partida> partidasActivas = new ArrayList();

    /** Lista de categorías disponibles. */
    private final ArrayList<String> categorias = new ArrayList<>();

    /** Instancia única de la categoría (Singleton). */
    private static Categoria instancia;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private Categoria() {
    }

    /**
     * Obtiene la instancia única de la categoría (Singleton).
     *
     * @return la instancia de la categoría
     */
    public static Categoria getInstance() {
        if (instancia == null) {
            instancia = new Categoria();
        }
        return instancia;
    }

    /**
     * Establece la categoría actual.
     *
     * @param nombre el nombre de la categoría
     * @throws IllegalArgumentException si la categoría no existe
     */
    public void setCategoria(String nombre) {
        if (nombre.equals("matematica") || nombre.equals("futbol") || nombre.equals("basket") || nombre.equals("videojuegos")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("La categoría no existe");
        }
    }

    /**
     * Agrega una nueva categoría a la lista de categorías disponibles.
     *
     * @param nombre el nombre de la categoría a agregar
     */
    public void appendCategoria(String nombre) {
        this.categorias.add(nombre);
    }

    /**
     * Obtiene la lista de categorías disponibles.
     *
     * @return la lista de categorías
     */
    public ArrayList<String> getCategorias(){
        return this.categorias;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return el nombre de la categoría
     */
    @Override
    public String nombreCategoria() {
        return this.nombre;
    }

    /**
     * Registra una nueva partida y devuelve su número.
     *
     * @return el número de la nueva partida registrada
     */
    @Override
    public int registrarPartida() {
        int nuevaPartida = 0;

        for (int i = 0; i < this.partidasActivas.size(); ++i) {
            int elemento = this.partidasActivas.get(i).getNumeroPartida();
            if (elemento > nuevaPartida) {
                nuevaPartida = elemento;
            }
        }

        ++nuevaPartida;
        this.partidasActivas.add(new Partida(nuevaPartida));
        return nuevaPartida;
    }

    /**
     * Finaliza una partida activa según su número.
     *
     * @param numeroPartida el número de la partida a finalizar
     * @throws excepcionPartidaNoDisponible si la partida no está disponible
     */
    @Override
    public void finalizarPartida(int numeroPartida) throws excepcionPartidaNoDisponible {
        boolean encontrada = false;

        for (int i = 0; i < this.partidasActivas.size(); ++i) {
            if (this.partidasActivas.get(i).getNumeroPartida() == numeroPartida) {
                this.partidasActivas.remove(i);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            throw new excepcionPartidaNoDisponible(String.format("La partida #%d no se encuentra disponible", numeroPartida));
        }
    }

    /**
     * Obtiene una pregunta aleatoria para la partida especificada.
     *
     * @param numeroPartida el número de la partida
     * @return la pregunta aleatoria obtenida
     * @throws excepcionPreguntasNoDisponibles si no hay preguntas disponibles
     */
    @Override
    public iPregunta obtenerPreguntaAleatoria(int numeroPartida) throws excepcionPreguntasNoDisponibles {
        int numeroDeElementos;

        // Verifica la categoría actual para determinar el tipo de preguntas disponibles
        if (this.nombre.equals("matematica")) {
            Matematica[] elementos = Matematica.values();
            numeroDeElementos = elementos.length;
        } else if (this.nombre.equals("futbol")) {
            Futbol[] elementos = Futbol.values();
            numeroDeElementos = elementos.length;
        } else if (this.nombre.equals("basket")) {
            Basket[] elementos = Basket.values();
            numeroDeElementos = elementos.length;
        } else {
            TriviaPreguntasVideojuegos[] elementos = TriviaPreguntasVideojuegos.values();
            numeroDeElementos = elementos.length;
        }

        Partida partida = null;

        for (int i = 0; i < this.partidasActivas.size(); ++i) {
            if (this.partidasActivas.get(i).getNumeroPartida() == numeroPartida) {
                partida = this.partidasActivas.get(i);
                break;
            }
        }

        assert partida != null; // Si la partida es nula, se lanza una excepción

        // Si el número de elementos es menor o igual al número de preguntas realizadas, se lanza una excepción
        if (numeroDeElementos <= partida.getPreguntasRealizadas().size()) {
            throw new excepcionPreguntasNoDisponibles();
        } else {
            long semilla = System.currentTimeMillis();
            Random random = new Random(semilla);

            int numeroAleatorio;
            for (numeroAleatorio = random.nextInt(numeroDeElementos); partida.getPreguntasRealizadas().contains(numeroAleatorio); numeroAleatorio = random.nextInt(numeroDeElementos)) {
            }

            partida.getPreguntasRealizadas().add(numeroAleatorio);

            // Se obtiene la pregunta aleatoria dependiendo de la categoría
            if (this.nombre.equals("matematica")) {
                Matematica[] preguntas = Matematica.values();
                Matematica preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            } else if (this.nombre.equals("futbol")) {
                Futbol[] preguntas = Futbol.values();
                Futbol preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            } else if (this.nombre.equals("basket")) {
                Basket[] preguntas = Basket.values();
                Basket preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            } else {
                TriviaPreguntasVideojuegos[] preguntas = TriviaPreguntasVideojuegos.values();
                TriviaPreguntasVideojuegos preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getPregunta();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            }
        }
    }

    /**
     * Publica el puntaje en los suscriptores de la partida especificada.
     *
     * @param numeroPartida el número de la partida
     * @throws excepcionPartidaNoDisponible si la partida no está disponible
     */
    @Override
    public void publicarEnSuscriptores(int numeroPartida) throws excepcionPartidaNoDisponible {
        Partida partida = null;

        for (int i = 0; i < this.partidasActivas.size(); ++i) {
            if (this.partidasActivas.get(i).getNumeroPartida() == numeroPartida) {
                partida = this.partidasActivas.get(i);
                break;
            }
        }

        if (partida == null) {
            throw new excepcionPartidaNoDisponible("Esta partida ya no existe activa");
        } else {
            Iterator var5 = partida.getListadoSuscriptores().iterator();

            while (var5.hasNext()) {
                iSuscriptorPreguntas suscriptor = (iSuscriptorPreguntas) var5.next();
                suscriptor.publicarPuntaje(partida.getJugadores());
            }
        }
    }


    /**
     * Agrega un suscriptor a la partida especificada.
     *
     * @param numeroPartida el número de la partida
     * @param sp el suscriptor de preguntas a agregar
     * @throws excepcionPartidaNoDisponible si la partida no está disponible
     */

    public void agregarSuscriptor(int numeroPartida, iSuscriptorPreguntas sp) throws excepcionPartidaNoDisponible {
        Partida partida = null;

        for(int i = 0; i < this.partidasActivas.size(); ++i) {
            if (((Partida)this.partidasActivas.get(i)).getNumeroPartida() == numeroPartida) {
                partida = (Partida)this.partidasActivas.get(i);
                break;
            }
        }

        if (partida == null) {
            throw new excepcionPartidaNoDisponible("Esta partida ya no existe activa");
        } else {
            partida.addSuscriptor(sp);
        }
    }

    /**
     * Agrega un jugador a la partida especificada.
     *
     * @param numeroPartida el número de la partida
     * @param jugador el jugador a agregar
     * @throws excepcionPartidaNoDisponible si la partida no está disponible
     */
    public void agregarJugador(int numeroPartida, iJugador jugador) throws excepcionPartidaNoDisponible {
        Partida partida = null;

        for(int i = 0; i < this.partidasActivas.size(); ++i) {
            if (((Partida)this.partidasActivas.get(i)).getNumeroPartida() == numeroPartida) {
                partida = (Partida)this.partidasActivas.get(i);
                break;
            }
        }

        if (partida == null) {
            throw new excepcionPartidaNoDisponible("Esta partida ya no existe activa");
        } else {
            partida.agregarJugador(jugador);
        }
    }

    /**
     * Obtiene la cantidad de preguntas existentes en la categoría.
     *
     * @return la cantidad de preguntas existentes
     */
    public short cantidadDePreguntasExistentes() {
        int numeroDeElementos;
        if (this.nombre == "matematica") {
            Matematica[] elementos = Matematica.values();
            numeroDeElementos = elementos.length;
        } else if (this.nombre == "futbol") {
            Futbol[] elementos = Futbol.values();
            numeroDeElementos = elementos.length;
        } else {
            Basket[] elementos = Basket.values();
            numeroDeElementos = elementos.length;
        }
        return (short)numeroDeElementos;
    }

    /**
     * Obtiene la partida activa con el número especificado.
     *
     * @param numeroDePartida el número de la partida
     * @return la partida activa o la primera partida si no se encuentra
     */
    public Partida obtenerPartida(int numeroDePartida) {
        for (Partida partida : this.partidasActivas) {
            if (partida.getNumeroPartida() == numeroDePartida) {
                return partida;
            }
        }
        return this.partidasActivas.get(0);
    }

    /**
     * Limpia la lista de categorías disponibles.
     */
    public void limpiarCategorias() {
        this.categorias.clear();
    }
}
