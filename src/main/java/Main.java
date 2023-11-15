import Frontend.MenuPrincipal;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws excepcionRangoMayor, FileNotFoundException, excepcionPreguntasNoDisponibles {
        MenuPrincipal.getInstance();
    }
}