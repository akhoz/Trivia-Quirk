import GUI.Home;
import Backend.Preguntas.Matematica;
import poo.proyecto2.triviaquirk.*;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws excepcionRangoMayor, FileNotFoundException {
        byte respuestaUsuario = 1;
        new Home();
        //System.out.println(Matematica.PREGUNTA_1.esCorrecta(respuestaUsuario));
    }
}
