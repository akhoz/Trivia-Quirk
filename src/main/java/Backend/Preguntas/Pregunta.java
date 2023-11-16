package Backend.Preguntas;

import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase que representa una pregunta en el juego.
 */
public class Pregunta implements iPregunta {

    private final String descripcion;
    private final int numeroPregunta;
    private final ArrayList<String> respuestas = new ArrayList<>();
    private final byte respuestaCorrecta;

    /**
     * Constructor de la clase Pregunta.
     *
     * @param numeroPregunta     el número de la pregunta
     * @param descripcion        la descripción de la pregunta
     * @param respuestaA         la primera opción de respuesta
     * @param respuestaB         la segunda opción de respuesta
     * @param respuestaC         la tercera opción de respuesta
     * @param respuestaCorrecta  la respuesta correcta
     */
    public Pregunta(int numeroPregunta, String descripcion, String respuestaA, String respuestaB, String respuestaC, byte respuestaCorrecta) {
        this.descripcion = descripcion;
        this.respuestas.add(respuestaA);
        this.respuestas.add(respuestaB);
        this.respuestas.add(respuestaC);
        this.respuestaCorrecta = respuestaCorrecta;
        this.numeroPregunta = numeroPregunta;
    }

    /**
     * Obtiene la descripción de la pregunta.
     *
     * @return la descripción de la pregunta
     */
    @Override
    public String obtenerDescripcion() {
        return this.descripcion;
    }

    /**
     * Obtiene la primera opción de respuesta.
     *
     * @return la primera opción de respuesta
     */
    @Override
    public String obtenerRespuesta1() {
        return this.respuestas.get(0);
    }

    /**
     * Obtiene la segunda opción de respuesta.
     *
     * @return la segunda opción de respuesta
     */
    @Override
    public String obtenerRespuesta2() {
        return this.respuestas.get(1);
    }

    /**
     * Obtiene la tercera opción de respuesta.
     *
     * @return la tercera opción de respuesta
     */
    @Override
    public String obtenerRespuesta3() {
        return this.respuestas.get(2);
    }

    /**
     * Verifica si la opción elegida es correcta y realiza el seguimiento de estadísticas.
     *
     * @param opcionElegida la opción elegida por el jugador
     * @return el valor asociado al rendimiento del jugador
     * @throws excepcionRangoMayor si la opción elegida está fuera de rango
     * @throws FileNotFoundException si no se encuentra el archivo de estadísticas
     */
    @Override
    public byte esCorrecta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        byte valor = 0;
        boolean encontrado = false;

        try (FileInputStream fileIn = new FileInputStream("src/main/java/Backend/Preguntas/Data/EstadisticaPreguntas.dat")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Registro> listaRecuperada = (ArrayList) in.readObject();
            in.close();

            for (Registro registro : listaRecuperada) {
                if (registro.numeroPregunta == this.numeroPregunta) {
                    encontrado = true;

                    if (this.respuestaCorrecta == opcionElegida) {
                        System.out.println("Acierto (encontrado)");
                        ++registro.aciertos;

                        int porcentajeIncorrecto = registro.desaciertos * 100 / (registro.desaciertos + registro.aciertos);

                        if (registro.aciertos + registro.desaciertos < 10) {
                            valor = 1;
                        } else if (porcentajeIncorrecto < 33) {
                            valor = 1;
                        } else if (porcentajeIncorrecto < 66) {
                            valor = 2;
                        } else {
                            valor = 3;
                        }
                    } else {
                        System.out.println("Incorrecto (encontrado)");
                        ++registro.desaciertos;
                    }

                    System.out.println(this.descripcion + " respuesta correcta: " + this.respuestaCorrecta);
                    System.out.println("Estadistica actual de la pregunta, Aciertos: " + registro.aciertos + ", Desaciertos: " + registro.desaciertos);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Acierto (no encontrado) ");
                System.out.println(this.descripcion + " respuesta correcta: " + this.respuestaCorrecta);
                if (this.respuestaCorrecta == opcionElegida) {
                    listaRecuperada.add(new Registro(this.numeroPregunta, 1, 0));
                    valor = 1;
                } else {
                    System.out.println("Incorrecto (no encontrado)");
                    listaRecuperada.add(new Registro(this.numeroPregunta, 0, 1));
                }
                System.out.println("No había estadística previa de esta pregunta");
            }

            try (FileOutputStream fileOut = new FileOutputStream("src/main/java/Backend/Preguntas/Data/EstadisticaPreguntas.dat");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(listaRecuperada);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            // Manejar el error adecuadamente
        }

        return valor;
    }

    /**
     * Realiza la evaluación por tiempo de respuesta agotado y realiza el seguimiento de estadísticas.
     *
     * @param opcionElegida la opción elegida por el jugador
     * @throws excepcionRangoMayor si la opción elegida está fuera de rango
     * @throws FileNotFoundException si no se encuentra el archivo de estadísticas
     */
    @Override
    public void falloPorTiempoRespuesta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        this.esCorrecta(opcionElegida);
        System.out.println("La respuesta no fue indicada y se auto-evaluó por vencimiento del tiempo de respuesta");
    }
}
