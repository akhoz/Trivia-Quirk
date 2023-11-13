package Backend.Preguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreguntaTest {

    @Test
    void obtenerDescripcion() {
        Pregunta pregunta = new Pregunta(1, "¿Cuál es la capital de Francia?", "París", "Berlín", "Londres", (byte) 1);
        assertEquals("¿Cuál es la capital de Francia?", pregunta.obtenerDescripcion());
    }

    @Test
    void obtenerRespuesta1() {
        Pregunta pregunta = new Pregunta(2, "¿Cuál es el río más largo del mundo?", "Amazonas", "Nilo", "Misisipi", (byte) 1);
        assertEquals("Amazonas", pregunta.obtenerRespuesta1());
    }


    @Test
    void esCorrecta_Acierto() {
        Pregunta pregunta = new Pregunta(3, "¿Cuántos lados tiene un triángulo?", "4", "3", "5", (byte) 2);
        try {
            assertEquals(1, pregunta.esCorrecta((byte) 2));
        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    void esCorrecta_Desacierto() {
        Pregunta pregunta = new Pregunta(4, "¿Cuál es el planeta más grande del sistema solar?", "Tierra", "Júpiter", "Marte", (byte) 2);
        try {
            assertEquals(0, pregunta.esCorrecta((byte) 3));
        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    void falloPorTiempoRespuesta() {
        Pregunta pregunta = new Pregunta(5, "¿Cuál es el océano más grande?", "Océano Pacífico", "Océano Atlántico", "Océano Índico", (byte) 1);
        try {
            pregunta.falloPorTiempoRespuesta((byte) 2);
        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }
}