package Frontend;

import Backend.Partida.*;

public class Trivia {
    private Categoria categoria;
    private Partida partida;

    public Trivia(Categoria categoria, Partida partida) {
        System.out.println("Jugadores registrados para la partida: " + partida.getNombreJugadores());
        System.out.println("Categoria seleccionada: " + categoria.nombreCategoria());
    }
}
