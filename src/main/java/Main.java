import Frontend.MenuPrincipal;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.FileNotFoundException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws excepcionRangoMayor             the excepcion rango mayor
     * @throws FileNotFoundException           the file not found exception
     * @throws excepcionPreguntasNoDisponibles the excepcion preguntas no disponibles
     */
    public static void main(String[] args) throws excepcionRangoMayor, FileNotFoundException, excepcionPreguntasNoDisponibles {
        MenuPrincipal.getInstance();
    }
}