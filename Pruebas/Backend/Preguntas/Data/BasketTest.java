package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Basket.
 */
class BasketTest {

    /**
     * Prueba para verificar si el método getDescripcion devuelve la descripción correcta de la pregunta de baloncesto.
     */
    @Test
    void getDescripcion() {
        assertEquals("¿Qué equipo de la NBA tiene el récord de más campeonatos de la NBA?", Basket.PREGUNTA_1.getDescripcion());
    }

    /**
     * Prueba para verificar si el método getRespuestaA devuelve la respuesta A correcta de la pregunta de baloncesto.
     */
    @Test
    void getRespuestaA() {
        assertEquals("Boston Celtics", Basket.PREGUNTA_1.getRespuestaA());
    }

    /**
     * Prueba para verificar si el método getRespuestaB devuelve la respuesta B correcta de la pregunta de baloncesto.
     */
    @Test
    void getRespuestaB() {
        assertEquals("Los Angeles Lakers", Basket.PREGUNTA_1.getRespuestaB());
    }

    /**
     * Prueba para verificar si el método getRespuestaC devuelve la respuesta C correcta de la pregunta de baloncesto.
     */
    @Test
    void getRespuestaC() {
        assertEquals("Chicago Bulls", Basket.PREGUNTA_1.getRespuestaC());
    }

    /**
     * Prueba para verificar si el método getRespuestaCorrecta devuelve la respuesta correcta de la pregunta de baloncesto.
     */
    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 1, Basket.PREGUNTA_1.getRespuestaCorrecta());
    }
}
