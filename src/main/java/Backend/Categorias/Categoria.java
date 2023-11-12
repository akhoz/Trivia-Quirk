package Backend.Categorias;

import Backend.Partida;
import Backend.Preguntas.Basket;
import Backend.Preguntas.Futbol;
import Backend.Preguntas.Matematica;
import Backend.Preguntas.Pregunta;
import poo.proyecto2.triviaquirk.excepciones.excepcionPartidaNoDisponible;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.iCategorias;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Categoria implements iCategorias {
    private String nombre;
    private final ArrayList<Partida> partidasActivas = new ArrayList();
    private static Categoria instancia;

    private Categoria(String nombre) {
        this.nombre = nombre;
    }

    private Categoria() {
    }

    public static Categoria getInstance(String nombre) { //Implementacion del patron Singleton
        if (instancia == null) {
            instancia = new Categoria(nombre);
        }
        return instancia;
    }

    @Override
    public String nombreCategoria() {
        return this.nombre;
    }

    @Override
    public int registrarPartida() {
        int nuevaPartida = 0;

        for(int i = 0; i < this.partidasActivas.size(); ++i) {
            int elemento = ((Partida)this.partidasActivas.get(i)).getNumeroPartida();
            if (elemento > nuevaPartida) {
                nuevaPartida = elemento;
            }
        }

        ++nuevaPartida;
        this.partidasActivas.add(new Partida(nuevaPartida));
        return nuevaPartida;
    }

    @Override
    public void finalizarPartida(int numeroPartida) throws excepcionPartidaNoDisponible {
        boolean encontrada = false;

        for(int i = 0; i < this.partidasActivas.size(); ++i) {
            if (((Partida)this.partidasActivas.get(i)).getNumeroPartida() == numeroPartida) {
                this.partidasActivas.remove(i);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            throw new excepcionPartidaNoDisponible(String.format("La partida #%d no se encuentra disponible", numeroPartida));
        }
    }

    @Override
    public iPregunta obtenerPreguntaAleatoria(int numeroPartida) throws excepcionPreguntasNoDisponibles {
        int numeroDeElementos;
        if (this.nombre == "Matematica") {
            Matematica[] elementos = Matematica.values();
            numeroDeElementos = elementos.length;
        } else if (this.nombre == "Futbol") {
            Futbol[] elementos = Futbol.values();
            numeroDeElementos = elementos.length;
        } else {
            Basket[] elementos = Basket.values();
            numeroDeElementos = elementos.length;
        }

        Partida partida = null;

        for (int i = 0; i < this.partidasActivas.size(); ++i) {
            if (((Partida)this.partidasActivas.get(i)).getNumeroPartida() == numeroPartida) {
                partida = (Partida)this.partidasActivas.get(i);
                break;
            }
        }

            assert partida != null; //Si la partida es nula, se lanza una excepcion

            //Si el numero de elementos es menor o igual al numero de preguntas realizadas, se lanza una excepcion
            if (numeroDeElementos <= partida.getPreguntasRealizadas().size()) {
            throw new excepcionPreguntasNoDisponibles();
        } else {
            long semilla = System.currentTimeMillis();
            Random random = new Random(semilla);

            int numeroAleatorio;
            for(numeroAleatorio = random.nextInt(numeroDeElementos); partida.getPreguntasRealizadas().contains(numeroAleatorio); numeroAleatorio = random.nextInt(numeroDeElementos)) {
            }

            partida.getPreguntasRealizadas().add(numeroAleatorio);

            //Se obtiene la pregunta aleatoria dependiendo de la categoria
            if (this.nombre.equals("Matematica")) {
                Matematica[] preguntas = Matematica.values();
                Matematica preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            } else if (this.nombre.equals("Futbol")) {
                Futbol[] preguntas = Futbol.values();
                Futbol preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            } else {
                Basket[] preguntas = Basket.values();
                Basket preguntaAleatoria = preguntas[numeroAleatorio];
                String descripcion = preguntaAleatoria.getDescripcion();
                String respuestaA = preguntaAleatoria.getRespuestaA();
                String respuestaB = preguntaAleatoria.getRespuestaB();
                String respuestaC = preguntaAleatoria.getRespuestaC();
                byte respuestaCorrecta = preguntaAleatoria.getRespuestaCorrecta();
                Pregunta preguntaSolicitada = new Pregunta(numeroAleatorio, descripcion, respuestaA, respuestaB, respuestaC, respuestaCorrecta);
                return preguntaSolicitada;
            }
        }
    }

    @Override
    public void publicarEnSuscriptores(int numeroPartida) throws excepcionPartidaNoDisponible {
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
            Iterator var5 = partida.getListadoSuscriptores().iterator();

            while(var5.hasNext()) {
                iSuscriptorPreguntas suscriptor = (iSuscriptorPreguntas)var5.next();
                suscriptor.publicarPuntaje(partida.getJugadores());
            }

        }
    }

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

    public short cantidadDePreguntasExistentes() {
        int numeroDeElementos;
        if (this.nombre == "Matematica") {
            Matematica[] elementos = Matematica.values();
            numeroDeElementos = elementos.length;
        } else if (this.nombre == "Futbol") {
            Futbol[] elementos = Futbol.values();
            numeroDeElementos = elementos.length;
        } else {
            Basket[] elementos = Basket.values();
            numeroDeElementos = elementos.length;
        }
        return (short)numeroDeElementos;
    }
}

