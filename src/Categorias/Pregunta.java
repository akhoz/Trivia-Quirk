package Categorias;

import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;
import poo.proyecto2.triviaquirk.iPregunta;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Pregunta implements iPregunta{
    private String pregunta;
    private ArrayList<String> respuestas;

    public Pregunta(String pregunta, ArrayList<String> respuestas){
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public String obtenerPregunta(){
        return this.pregunta;
    }

    @Override
    public String obtenerDescripcion(){
        return this.pregunta;
    }

    @Override
    public String obtenerRespuesta1(){
        return this.respuestas.get(0);
    }

    @Override
    public String obtenerRespuesta2(){
        return this.respuestas.get(1);
    }

    @Override
    public String obtenerRespuesta3(){
        return this.respuestas.get(2);
    }

    @Override
    public byte esCorrecta(byte b) throws excepcionRangoMayor, FileNotFoundException {
        return 0;
    }

    @Override
    public void falloPorTiempoRespuesta(byte b) throws excepcionRangoMayor, FileNotFoundException {

    }
}
