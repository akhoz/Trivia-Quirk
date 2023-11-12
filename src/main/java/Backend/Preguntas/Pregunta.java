package Backend.Preguntas;

import poo.proyecto2.triviaquirk.iPregunta;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;

import java.util.ArrayList;
import java.io.FileNotFoundException;
public class Pregunta implements iPregunta{
    private final String descripcion;
    private final ArrayList<String> respuestas = new ArrayList<>();
    private final byte respuestaCorrecta;


    public Pregunta(String descripcion, String respuestA, String respuestB, String respuestaC, byte respuestaCorrecta){
        this.descripcion = descripcion;
        this.respuestas.add(respuestA);
        this.respuestas.add(respuestB);
        this.respuestas.add(respuestaC);
        this.respuestaCorrecta = respuestaCorrecta;
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
        //TO define
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
