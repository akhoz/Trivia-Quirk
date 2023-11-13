import Frontend.MenuPrincipal;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws excepcionRangoMayor, FileNotFoundException, excepcionPreguntasNoDisponibles {
        byte respuestaUsuario = 1;
        MenuPrincipal.getInstance();
        /*
        Categoria categoria = Categoria.getInstance();
        categoria.setCategoria("Matematica");
        int partidaUno = categoria.registrarPartida();
        iPregunta pregunta = categoria.obtenerPreguntaAleatoria(partidaUno);


        try {
            System.out.println(pregunta.esCorrecta(respuestaUsuario));
        } catch (FileNotFoundException var17) {
            System.out.println("El archivo de estadísticas no existe y no se puedo utilizar esta categoría");
            String nombreArchivo = "HCEstadistica.dat";

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
                writer.close();
                System.out.println("Se ha creado el archivo: " + nombreArchivo);
            } catch (IOException var14) {
                System.out.println("No se ha creado el archivo: " + nombreArchivo);
            }
        }
         */
    }
}
