package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FutbolTest {

    @Test
    void getDescripcion() {
        assertEquals("¿Cuántas veces ha ganado Lionel Messi la UEFA Champions League?", Futbol.PREGUNTA_1.getDescripcion());
    }

    @Test
    void getRespuestaA() {
        assertEquals("3", Futbol.PREGUNTA_1.getRespuestaA());
    }

    @Test
    void getRespuestaB() {
        assertEquals("4", Futbol.PREGUNTA_1.getRespuestaB());
    }

    @Test
    void getRespuestaC() {
        assertEquals("5", Futbol.PREGUNTA_1.getRespuestaC());
    }

    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 2, Futbol.PREGUNTA_1.getRespuestaCorrecta());
    }
}