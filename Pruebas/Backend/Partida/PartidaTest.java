package Backend.Partida;

import org.junit.jupiter.api.Test;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Partida.
 */
class PartidaTest {

    /**
     * Prueba para verificar si getNumeroPartida devuelve el número correcto de la partida.
     */
    @Test
    void getNumeroPartida() {
        Partida partida = new Partida(1);
        assertEquals(1, partida.getNumeroPartida());
    }

    /**
     * Prueba para verificar si getListadoSuscriptores devuelve una lista no nula y vacía al inicio.
     */
    @Test
    void getListadoSuscriptores() {
        Partida partida = new Partida(2);
        assertNotNull(partida.getListadoSuscriptores());
        assertTrue(partida.getListadoSuscriptores().isEmpty());
    }

    /**
     * Prueba para verificar si addSuscriptor agrega correctamente un suscriptor a la lista.
     */
    @Test
    void addSuscriptor() {
        Partida partida = new Partida(3);
        iSuscriptorPreguntas suscriptor = parametro -> {
        };
        partida.addSuscriptor(suscriptor);
        assertFalse(partida.getListadoSuscriptores().isEmpty());
        assertTrue(partida.getListadoSuscriptores().contains(suscriptor));
    }

    /**
     * Prueba para verificar si getPreguntasRealizadas devuelve una lista no nula y vacía al inicio.
     */
    @Test
    void getPreguntasRealizadas() {
        Partida partida = new Partida(4);
        assertNotNull(partida.getPreguntasRealizadas());
        assertTrue(partida.getPreguntasRealizadas().isEmpty());
    }

    /**
     * Prueba para verificar si getJugadores devuelve una lista no nula y vacía al inicio.
     */
    @Test
    void getJugadores() {
        Partida partida = new Partida(5);
        assertNotNull(partida.getJugadores());
        assertTrue(partida.getJugadores().isEmpty());
    }

    /**
     * Prueba para verificar si getNombreJugadores devuelve una lista vacía al inicio.
     */
    @Test
    void getNombreJugadores() {
        Partida partida = new Partida(6);
        assertEquals(0, partida.getNombreJugadores().size());
    }

    /**
     * Prueba para verificar si agregarJugador agrega correctamente un jugador a la lista.
     */
    @Test
    void agregarJugador() {
        Partida partida = new Partida(7);
        iJugador jugador = new iJugador() {
            @Override
            public String obtenerNombreJugador() {
                return "Jugador1";
            }
            @Override
            public short obtenerPuntaje() {
                return 0;
            }
            @Override
            public short aumentarPuntaje(short var1) {
                return 0;
            }
        };
        partida.agregarJugador(jugador);
        assertFalse(partida.getJugadores().isEmpty());
        assertTrue(partida.getNombreJugadores().contains("Jugador1"));
    }

    /**
     * Prueba para verificar si toString devuelve el formato esperado.
     */
    @Test
    void testToString() {
        Partida partida = new Partida(8);
        assertEquals("Partida 8", partida.toString());
    }

    /**
     * Prueba para verificar si limpiarPreguntasRealizadas elimina todas las preguntas realizadas.
     */
    @Test
    void limpiarPreguntasRealizadas() {
        Partida partida = new Partida(1);
        partida.getPreguntasRealizadas().add(1);
        partida.getPreguntasRealizadas().add(2);
        partida.getPreguntasRealizadas().add(3);
        partida.limpiarPreguntasRealizadas();
        assertEquals(0, partida.getPreguntasRealizadas().size());
    }
}
