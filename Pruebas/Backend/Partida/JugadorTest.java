package Backend.Partida;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Jugador.
 */
class JugadorTest {

    /**
     * Prueba para verificar si obtenerNombreJugador devuelve el nombre correcto del jugador.
     */
    @Test
    void obtenerNombreJugador() {
        Jugador jugador = new Jugador("Jugador1");
        assertEquals("Jugador1", jugador.obtenerNombreJugador());
    }

    /**
     * Prueba para verificar si obtenerPuntaje devuelve 0 al inicio.
     */
    @Test
    void obtenerPuntaje() {
        Jugador jugador = new Jugador("Jugador2");
        assertEquals(0, jugador.obtenerPuntaje());
    }

    /**
     * Prueba para verificar si aumentarPuntaje incrementa el puntaje correctamente.
     */
    @Test
    void aumentarPuntaje() {
        Jugador jugador = new Jugador("Jugador3");
        assertEquals(10, jugador.aumentarPuntaje((short) 10));
        assertEquals(20, jugador.aumentarPuntaje((short) 10));
        assertEquals(30, jugador.aumentarPuntaje((short) 10));
    }
}
