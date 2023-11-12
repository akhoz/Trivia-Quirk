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
        FileInputStream fileIn = new FileInputStream("src/main/java/Backend/Preguntas/EstadisticaPreguntas.dat");

        try {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Registro> listaRecuperada = (ArrayList)in.readObject();
            in.close();
            fileIn.close();
            Iterator var8 = listaRecuperada.iterator();

            while(var8.hasNext()) {
                Registro registro = (Registro)var8.next();
                if (registro.numeroPregunta == this.numeroPregunta) {
                    if (this.respuestaCorrecta == opcionElegida) {
                        ++registro.aciertos;
                        if (registro.desaciertos + registro.aciertos < 10) {
                            valor = 1;
                        } else if (registro.desaciertos * 100 / (registro.desaciertos + registro.aciertos) < 33) {
                            valor = 1;
                        } else if (registro.desaciertos * 100 / (registro.desaciertos + registro.aciertos) < 66) {
                            valor = 2;
                        } else {
                            valor = 3;
                        }
                    } else {
                        ++registro.desaciertos;
                    }

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                if (this.respuestaCorrecta == opcionElegida) {
                    listaRecuperada.add(new Registro(this.numeroPregunta, 1, 0));
                } else {
                    listaRecuperada.add(new Registro(this.numeroPregunta, 0, 1));
                }
            }

            FileOutputStream fileOut = new FileOutputStream("src/main/java/Backend/Preguntas/EstadisticaPreguntas.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaRecuperada);
            out.close();
            fileOut.close();
        } catch (IOException var13) {
            System.out.println("EError: " + var13.getMessage());
            FileOutputStream fileOut = new FileOutputStream("src/main/java/Backend/Preguntas/EstadisticaPreguntas.dat");

            try {
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                ArrayList<Registro> nuevaLista = new ArrayList();
                if (this.respuestaCorrecta == opcionElegida) {
                    nuevaLista.add(new Registro(this.numeroPregunta, 1, 0));
                } else {
                    nuevaLista.add(new Registro(this.numeroPregunta, 0, 1));
                }

                out.writeObject(nuevaLista);
            } catch (IOException var12) {
                System.out.println("No se puede escrinir en el archivo");
            }

            System.out.println("No se puede abrir el archivo de estadística y se crea uno nuevo");
        } catch (ClassNotFoundException var14) {
            System.out.println("La clase RegistroEstadistico no esta disponible");
        }

        return valor;
    }

    @Override
    public void falloPorTiempoRespuesta(byte opcionElegida) throws excepcionRangoMayor, FileNotFoundException {
        this.esCorrecta(opcionElegida);
        System.out.println("La respuesta no fue indicada y se auto-evaluó por vencimiento del tiempo de respuesta");
    }
}
