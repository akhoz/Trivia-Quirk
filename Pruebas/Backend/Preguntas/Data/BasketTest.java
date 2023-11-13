package Backend.Preguntas.Data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void getDescripcion() {
        assertEquals("¿Qué equipo de la NBA tiene el récord de más campeonatos de la NBA?", Basket.PREGUNTA_1.getDescripcion());
    }

    @Test
    void getRespuestaA() {
        assertEquals("Boston Celtics", Basket.PREGUNTA_1.getRespuestaA());
    }

    @Test
    void getRespuestaB() {
        assertEquals("Los Angeles Lakers", Basket.PREGUNTA_1.getRespuestaB());
    }

    @Test
    void getRespuestaC() {
        assertEquals("Chicago Bulls", Basket.PREGUNTA_1.getRespuestaC());
    }

    @Test
    void getRespuestaCorrecta() {
        assertEquals((byte) 1, Basket.PREGUNTA_1.getRespuestaCorrecta());
    }
}