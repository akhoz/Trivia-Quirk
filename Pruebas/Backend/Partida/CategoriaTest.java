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

class CategoriaTest {

    @Test
    void getInstance() {
        Categoria categoria1 = Categoria.getInstance();
        Categoria categoria2 = Categoria.getInstance();
        assertNotNull(categoria1);
        assertNotNull(categoria2);
        assertSame(categoria1, categoria2);
    }

    @Test
    void setCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("matematica");
        assertEquals("matematica", categoria.nombreCategoria());
    }

    @Test
    void appendCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.getCategorias().clear();
        categoria.appendCategoria("futbol");
        categoria.appendCategoria("dragon");

        assertEquals(2, categoria.getCategorias().size());
    }

    @Test
    void getCategorias() {
        Categoria categoria = Categoria.getInstance();
        categoria.appendCategoria("futbol");
        categoria.appendCategoria("dragon");
        assertEquals("dragon", categoria.getCategorias().get(1));
    }
    @Test
    void nombreCategoria() {
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("futbol");
        assertEquals("futbol", categoria.nombreCategoria());
    }

    @Test
    void registrarPartida() {
        Categoria categoria = Categoria.getInstance();
        int numeroPartida = categoria.registrarPartida();
        assertTrue(numeroPartida > 0);
    }

    @Test
    void finalizarPartida() {
        Categoria categoria = Categoria.getInstance();
        int numeroPartida = categoria.registrarPartida();
        assertDoesNotThrow(() -> categoria.finalizarPartida(numeroPartida));
    }

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

    /*
    @Test
    void publicarEnSuscriptores() {
        Categoria categoria = Categoria.getInstance();
        int numeroPartida = categoria.registrarPartida();
        iSuscriptorPreguntas suscriptor = new
        assertDoesNotThrow(() -> {
            categoria.agregarSuscriptor(numeroPartida, suscriptor);
            categoria.publicarEnSuscriptores(numeroPartida);
        });
    }

    @Test
    void agregarSuscriptor() {
        Categoria categoria = Categoria.getInstance();
        iSuscriptorPreguntas suscriptor = new
        int numeroPartida = categoria.registrarPartida();

        assertDoesNotThrow(() -> categoria.agregarSuscriptor(numeroPartida, suscriptor));
    }
     */

    @Test
    void agregarJugador() throws excepcionPartidaNoDisponible {
        Categoria categoria = Categoria.getInstance();
        Jugador jugador = new Jugador("Pepito") {
        };
        int numeroPartida = categoria.registrarPartida();
        categoria.agregarJugador(numeroPartida, jugador);

        assertDoesNotThrow(() -> categoria.agregarJugador(numeroPartida, jugador));
    }

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
}