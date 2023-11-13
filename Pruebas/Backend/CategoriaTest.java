package Backend;

import Backend.Partida.Categoria;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.iPregunta;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    @org.junit.jupiter.api.Test
    void nombreCategoria() {
        assertEquals("Matematica", Categoria.getInstance("Matematica").nombreCategoria());
    }

    @org.junit.jupiter.api.Test
    void registrarPartida() {
        assertEquals(1, Categoria.getInstance("Matematica").registrarPartida());
        assertEquals(2, Categoria.getInstance("Basket").registrarPartida());
        assertEquals(3, Categoria.getInstance("Futbol").registrarPartida());
    }

    @org.junit.jupiter.api.Test
    void obtenerPreguntaAleatoria() throws excepcionPreguntasNoDisponibles {
        Categoria.getInstance("Matematica").registrarPartida();
        assertInstanceOf(iPregunta.class, Categoria.getInstance("Matematica").obtenerPreguntaAleatoria(1));
    }

    @org.junit.jupiter.api.Test
    void publicarEnSuscriptores() {
    }

    @org.junit.jupiter.api.Test
    void agregarSuscriptor() {
    }

    @org.junit.jupiter.api.Test
    void agregarJugador() {
    }

    @org.junit.jupiter.api.Test
    void cantidadDePreguntasExistentes() throws excepcionPreguntasNoDisponibles {
        assertEquals(30, Categoria.getInstance("Matematica").cantidadDePreguntasExistentes());
        assertEquals(30, Categoria.getInstance("Futbol").cantidadDePreguntasExistentes());
        assertEquals(30, Categoria.getInstance("Basket").cantidadDePreguntasExistentes());
    }
}