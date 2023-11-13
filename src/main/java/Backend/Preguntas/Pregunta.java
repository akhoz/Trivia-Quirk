package Backend.Preguntas;

import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Pregunta implements iPregunta{
    private final String descripcion;
    private final int numeroPregunta;
    private final ArrayList<String> respuestas = new ArrayList<>();
    private final byte respuestaCorrecta;

    public Pregunta(int numeroPregunta, String descripcion, String respuestA, String respuestB, String respuestaC, byte respuestaCorrecta){
        this.descripcion = descripcion;
        this.respuestas.add(respuestA);
        this.respuestas.add(respuestB);
        this.respuestas.add(respuestaC);
        this.respuestaCorrecta = respuestaCorrecta;
        this.numeroPregunta = numeroPregunta;
    }

    @Override
    public String obtenerDescripcion() {
        return this.descripcion;
    }

    @Override
    public String obtenerRespuesta1() {
        return this.respuestas.get(0);
    }

    @Override
    public String obtenerRespuesta2() {
        return this.respuestas.get(1);
    }

    @Override
    public String obtenerRespuesta3() {
        return this.respuestas.get(2);
    }

    @Override
    public byte esCorrecta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        byte valor = 0;
        boolean encontrado = false;

        FileInputStream fileIn = new FileInputStream("src/main/java/Backend/Preguntas/Data/EstadisticaPreguntas.dat");

        try {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Registro> listaRecuperada = (ArrayList)in.readObject();
            in.close();
            fileIn.close();

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
                System.out.println("No habia estadistica previa de esta pregunta");
            }

            FileOutputStream fileOut = new FileOutputStream("src/main/java/Backend/Preguntas/Data/EstadisticaPreguntas.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaRecuperada);
            out.close();
            fileOut.close();
        } catch (IOException var13) {
            System.out.println("Error: " + var13.getMessage());
            // Manejar el error adecuadamente
        } catch (ClassNotFoundException var14) {
            System.out.println("La clase RegistroEstadistico no está disponible");
            // Manejar el error adecuadamente
        }

        return valor;
    }


    @Override
    public void falloPorTiempoRespuesta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        this.esCorrecta(opcionElegida);
        System.out.println("La respuesta no fue indicada y se auto-evaluó por vencimiento del tiempo de respuesta");
    }
}
