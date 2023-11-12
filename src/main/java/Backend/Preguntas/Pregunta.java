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
    public byte esCorrecta(byte opcionSeleccionada) throws excepcionRangoMayor, FileNotFoundException {
        byte puntos = 0;
        boolean preguntaEnArchivo = false;
        FileInputStream archivo = new FileInputStream("src/main/java/Backend/Preguntas/EstadisticaPreguntas.dat");

        try {
            ObjectInputStream in = new ObjectInputStream(archivo);
            ArrayList<Registro> listaRecuperada = (ArrayList)in.readObject();
            in.close();
            archivo.close();
            Iterator iterador = listaRecuperada.iterator();

            while(iterador.hasNext()) {
                Registro registro = (Registro) iterador.next(); //Esto es para recorrer el archivo
                if (registro.numeroPregunta == this.numeroPregunta) { //Si la pregunta ya existe en el archivo, se hace la comparación para otorgar puntos
                    if (this.respuestaCorrecta == opcionSeleccionada) { //Si la respuesta es correcta, se analizan los fallos para dar 1, 2 o 3 puntos
                        ++registro.aciertos;
                        if (registro.desaciertos + registro.aciertos < 10) { //Si no hay suficiente estadistica, se otorga 1 punto
                            puntos = 1;
                        } else if (registro.desaciertos * 100 / (registro.desaciertos + registro.aciertos) < 33) { //Si el porcentaje de fallos es menor a 33%. se otorga 1 punto
                            puntos = 1;
                        } else if (registro.desaciertos * 100 / (registro.desaciertos + registro.aciertos) < 66) { //Si el porcentaje de fallos es menor a 66%. se otorga 2 puntos
                            puntos = 2;
                        } else { //Si supera el 66% de fallos, se otorgan 3 puntos
                            puntos = 3;
                        }
                    } else {
                        ++registro.desaciertos;
                    }

                    preguntaEnArchivo = true;
                    break;
                }
            }
            if (!preguntaEnArchivo) { //Si la pregunta no existe en el archivo, se crea un nuevo registro y se asignan los puntos
                if (this.respuestaCorrecta == opcionSeleccionada) {
                    listaRecuperada.add(new Registro(this.numeroPregunta, 1, 0));
                    puntos = 1;
                } else {
                    listaRecuperada.add(new Registro(this.numeroPregunta, 0, 1));
                }

            }

            //Se guarda la lista en el archivo
            FileOutputStream fileOut = new FileOutputStream("src/main/java/Backend/Preguntas/EstadisticaPreguntas.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaRecuperada);
            out.close();
            fileOut.close();
        }  catch (IOException | ClassNotFoundException var10) { //Si hay un error, se imprime el error
            var10.printStackTrace();
        }
        return puntos;
    }

    @Override
    public void falloPorTiempoRespuesta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        this.esCorrecta(opcionElegida);
        System.out.println("La respuesta no fue indicada y se auto-evaluó por vencimiento del tiempo de respuesta");
    }
}
