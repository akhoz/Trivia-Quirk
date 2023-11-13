package Backend.Partida;

import org.junit.jupiter.api.Test;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void getNumeroPartida() {
            Partida partida = new Partida(1);
            assertEquals(1, partida.getNumeroPartida());
        }

    @Test
    void getListadoSuscriptores() {
            Partida partida = new Partida(2);
            assertNotNull(partida.getListadoSuscriptores());
            assertTrue(partida.getListadoSuscriptores().isEmpty());
        }

    @Test
    void addSuscriptor() {
        Partida partida = new Partida(3);
        iSuscriptorPreguntas suscriptor = parametro -> {
        };
        partida.addSuscriptor(suscriptor);
        assertFalse(partida.getListadoSuscriptores().isEmpty());
        assertTrue(partida.getListadoSuscriptores().contains(suscriptor));
    }

    @Test
    void getPreguntasRealizadas() {
            Partida partida = new Partida(4);
            assertNotNull(partida.getPreguntasRealizadas());
            assertTrue(partida.getPreguntasRealizadas().isEmpty());
    }

    @Test
    void getJugadores() {
            Partida partida = new Partida(5);
            assertNotNull(partida.getJugadores());
            assertTrue(partida.getJugadores().isEmpty());
    }

    @Test
    void getNombreJugadores() {
            Partida partida = new Partida(6);
            assertEquals(0, partida.getNombreJugadores().size());
    }

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

    @Test
    void testToString() {
            Partida partida = new Partida(8);
            assertEquals("Partida 8", partida.toString());
    }
}