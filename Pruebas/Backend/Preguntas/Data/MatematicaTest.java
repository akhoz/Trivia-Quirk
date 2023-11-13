package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatematicaTest {

    @Test
    void getDescripcion() {
        assertEquals("Calcular la derivada de ln(x)", Matematica.PREGUNTA_1.getDescripcion());
    }

    @Test
    void getRespuestaA() {
        assertEquals("1/x", Matematica.PREGUNTA_1.getRespuestaA());
    }

    @Test
    void getRespuestaB() {
        assertEquals("x", Matematica.PREGUNTA_1.getRespuestaB());
    }

    @Test
    void getRespuestaC() {
        assertEquals("2/x", Matematica.PREGUNTA_1.getRespuestaC());
    }

    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 1, Matematica.PREGUNTA_1.getRespuestaCorrecta());
    }
}