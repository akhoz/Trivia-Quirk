package Backend;

import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.util.ArrayList;
import java.io.FileNotFoundException;
public class Pregunta implements iPregunta{
    private final String descripcion;
    private final ArrayList<String> respuestas;

    private final byte respuestaCorrecta;
    private int aciertos;
    private int fallos;

    public Pregunta(String descripcion, ArrayList<String> respuestas){
        this.descripcion = descripcion;
        this.respuestas = respuestas;
        this.respuestaCorrecta = 0;
        this.aciertos = 0;
        this.fallos = 0;
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
    public byte esCorrecta(byte var1) throws excepcionRangoMayor, FileNotFoundException {
        //PREGUNTAR
        if (var1 > 3) {
            throw new excepcionRangoMayor();
        }
        return var1;
    }

    @Override
    public void falloPorTiempoRespuesta(byte var1) throws excepcionRangoMayor, FileNotFoundException {
        //PREGUNTAR
        if (var1 > 20) {
            throw new excepcionRangoMayor();
        }
    }

    public void actualizarRegistro() {
        // Este es para guardar la pregunta en el json
    }

}
