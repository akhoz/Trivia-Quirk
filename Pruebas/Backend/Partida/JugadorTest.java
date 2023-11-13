package Backend.Partida;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void obtenerNombreJugador() {
        Jugador jugador = new Jugador("Jugador1");
        assertEquals("Jugador1", jugador.obtenerNombreJugador());
    }

    @Test
    void obtenerPuntaje() {
        Jugador jugador = new Jugador("Jugador2");
        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    void aumentarPuntaje() {
        Jugador jugador = new Jugador("Jugador3");
        assertEquals(10, jugador.aumentarPuntaje((short) 10));
        assertEquals(20, jugador.aumentarPuntaje((short) 10));
        assertEquals(30, jugador.aumentarPuntaje((short) 10));
    }
}