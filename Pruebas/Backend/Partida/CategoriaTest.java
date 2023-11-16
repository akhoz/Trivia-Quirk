package Backend.Partida;

import Backend.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;
import poo.proyecto2.triviaquirk.excepciones.excepcionPartidaNoDisponible;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Categoria.
 */
class CategoriaTest {

    /**
     * Prueba para verificar si getInstance devuelve la misma instancia.
     */
    @Test
    void getInstance() {
        Categoria categoria1 = Categoria.getInstance();
        Categoria categoria2 = Categoria.getInstance();
        assertNotNull(categoria1);
        assertNotNull(categoria2);
        assertSame(categoria1, categoria2);
    }

    /**
     * Prueba para verificar si setCategoria establece correctamente el nombre de la categoría.
     */
    @Test
    void setCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("matematica");
        assertEquals("matematica", categoria.nombreCategoria());
    }

    /**
     * Prueba para verificar si appendCategoria agrega categorías correctamente.
     */
    @Test
    void appendCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.getCategorias().clear();
        categoria.appendCategoria("futbol");
        categoria.appendCategoria("dragon");

        assertEquals(2, categoria.getCategorias().size());
    }

    /**
     * Prueba para verificar si getCategorias devuelve la categoría correcta.
     */
    @Test
    void getCategorias() {
        Categoria categoria = Categoria.getInstance();
        categoria.appendCategoria("futbol");
        categoria.appendCategoria("dragon");
        assertEquals("dragon", categoria.getCategorias().get(1));
    }

    /**
     * Prueba para verificar si nombreCategoria devuelve el nombre correcto de la categoría.
     */
    @Test
    void nombreCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("futbol");
        assertEquals("futbol", categoria.nombreCategoria());
    }

    /**
     * Prueba para verificar si registrarPartida devuelve un número de partida válido.
     */
    @Test
    void registrarPartida() {
        Categoria categoria = Categoria.getInstance();
        int numeroPartida = categoria.registrarPartida();
        assertTrue(numeroPartida > 0);
    }

    /**
     * Prueba para verificar si finalizarPartida no arroja excepciones.
     */
    @Test
    void finalizarPartida() {
        Categoria categoria = Categoria.getInstance();
        int numeroPartida = categoria.registrarPartida();
        assertDoesNotThrow(() -> categoria.finalizarPartida(numeroPartida));
    }

    /**
     * Prueba para verificar si obtenerPreguntaAleatoria no arroja excepciones y devuelve una pregunta no nula.
     */
    @Test
    void obtenerPreguntaAleatoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("matematica");
        int numeroPartida = categoria.registrarPartida();

        assertDoesNotThrow(() -> {
            iPregunta pregunta = categoria.obtenerPreguntaAleatoria(numeroPartida);
            assertNotNull(pregunta);
        });
    }

    /**
     * Prueba para verificar si agregarJugador no arroja excepciones.
     */
    @Test
    void agregarJugador() throws excepcionPartidaNoDisponible {
        Categoria categoria = Categoria.getInstance();
        Jugador jugador = new Jugador("Pepito") {};
        int numeroPartida = categoria.registrarPartida();
        categoria.agregarJugador(numeroPartida, jugador);

        assertDoesNotThrow(() -> categoria.agregarJugador(numeroPartida, jugador));
    }

    /**
     * Prueba para verificar si cantidadDePreguntasExistentes devuelve el número correcto de preguntas para diferentes categorías.
     */
    @Test
    void cantidadDePreguntasExistentes() throws excepcionPreguntasNoDisponibles {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("matematica");
        assertEquals(30, categoria.cantidadDePreguntasExistentes());
        categoria.setCategoria("futbol");
        assertEquals(30, categoria.cantidadDePreguntasExistentes());
        categoria.setCategoria("basket");
        assertEquals(30, categoria.cantidadDePreguntasExistentes());
    }

    /**
     * Prueba para verificar si limpiarCategorias borra las categorías correctamente.
     */
    @Test
    void limpiarCategorias() {
        Categoria categoria = Categoria.getInstance();
        categoria.appendCategoria("matematica");
        categoria.appendCategoria("matematica2");
        categoria.appendCategoria("matematica3");
        categoria.limpiarCategorias();
        assertEquals(0, categoria.getCategorias().size());
    }
}
