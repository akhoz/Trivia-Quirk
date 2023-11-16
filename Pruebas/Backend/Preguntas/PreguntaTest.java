package Backend.Preguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Pregunta.
 */
class PreguntaTest {

    /**
     * Prueba para verificar si obtenerDescripcion devuelve la descripción correcta de la pregunta.
     */
    @Test
    void obtenerDescripcion() {
        Pregunta pregunta = new Pregunta(1, "¿Cuál es la capital de Francia?", "París", "Berlín", "Londres", (byte) 1);
        assertEquals("¿Cuál es la capital de Francia?", pregunta.obtenerDescripcion());
    }

    /**
     * Prueba para verificar si obtenerRespuesta1 devuelve la primera respuesta correcta de la pregunta.
     */
    @Test
    void obtenerRespuesta1() {
        Pregunta pregunta = new Pregunta(2, "¿Cuál es el río más largo del mundo?", "Amazonas", "Nilo", "Misisipi", (byte) 1);
        assertEquals("Amazonas", pregunta.obtenerRespuesta1());
    }

    /**
     * Prueba para verificar si esCorrecta devuelve 1 (acierto) para una respuesta correcta.
     */
    @Test
    void esCorrecta_Acierto() {
        Pregunta pregunta = new Pregunta(3, "¿Cuántos lados tiene un triángulo?", "4", "3", "5", (byte) 2);
        try {
            assertEquals(1, pregunta.esCorrecta((byte) 2));
        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    /**
     * Prueba para verificar si esCorrecta devuelve 0 (desacierto) para una respuesta incorrecta.
     */
    @Test
    void esCorrecta_Desacierto() {
        Pregunta pregunta = new Pregunta(4, "¿Cuál es el planeta más grande del sistema solar?", "Tierra", "Júpiter", "Marte", (byte) 2);
        try {
            assertEquals(0, pregunta.esCorrecta((byte) 3));
        } catch (Exception e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    /**
     * Prueba para verificar si falloPorTiempoRespuesta no arroja excepciones inesperadas.
     */
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
