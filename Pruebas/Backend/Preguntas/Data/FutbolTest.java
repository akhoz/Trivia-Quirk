package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Futbol.
 */
class FutbolTest {

    /**
     * Prueba para verificar si el método getDescripcion devuelve la descripción correcta de la pregunta de fútbol.
     */
    @Test
    void getDescripcion() {
        assertEquals("¿Cuántas veces ha ganado Lionel Messi la UEFA Champions League?", Futbol.PREGUNTA_1.getDescripcion());
    }

    /**
     * Prueba para verificar si el método getRespuestaA devuelve la respuesta A correcta de la pregunta de fútbol.
     */
    @Test
    void getRespuestaA() {
        assertEquals("3", Futbol.PREGUNTA_1.getRespuestaA());
    }

    /**
     * Prueba para verificar si el método getRespuestaB devuelve la respuesta B correcta de la pregunta de fútbol.
     */
    @Test
    void getRespuestaB() {
        assertEquals("4", Futbol.PREGUNTA_1.getRespuestaB());
    }

    /**
     * Prueba para verificar si el método getRespuestaC devuelve la respuesta C correcta de la pregunta de fútbol.
     */
    @Test
    void getRespuestaC() {
        assertEquals("5", Futbol.PREGUNTA_1.getRespuestaC());
    }

    /**
     * Prueba para verificar si el método getRespuestaCorrecta devuelve la respuesta correcta de la pregunta de fútbol.
     */
    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 2, Futbol.PREGUNTA_1.getRespuestaCorrecta());
    }
}
