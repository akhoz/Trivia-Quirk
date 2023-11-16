package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Matematica.
 */
class MatematicaTest {

    /**
     * Prueba para verificar si el método getDescripcion devuelve la descripción correcta de la pregunta de matemáticas.
     */
    @Test
    void getDescripcion() {
        assertEquals("Calcular la derivada de ln(x)", Matematica.PREGUNTA_1.getDescripcion());
    }

    /**
     * Prueba para verificar si el método getRespuestaA devuelve la respuesta A correcta de la pregunta de matemáticas.
     */
    @Test
    void getRespuestaA() {
        assertEquals("1/x", Matematica.PREGUNTA_1.getRespuestaA());
    }

    /**
     * Prueba para verificar si el método getRespuestaB devuelve la respuesta B correcta de la pregunta de matemáticas.
     */
    @Test
    void getRespuestaB() {
        assertEquals("x", Matematica.PREGUNTA_1.getRespuestaB());
    }

    /**
     * Prueba para verificar si el método getRespuestaC devuelve la respuesta C correcta de la pregunta de matemáticas.
     */
    @Test
    void getRespuestaC() {
        assertEquals("2/x", Matematica.PREGUNTA_1.getRespuestaC());
    }

    /**
     * Prueba para verificar si el método getRespuestaCorrecta devuelve la respuesta correcta de la pregunta de matemáticas.
     */
    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 1, Matematica.PREGUNTA_1.getRespuestaCorrecta());
    }
}
