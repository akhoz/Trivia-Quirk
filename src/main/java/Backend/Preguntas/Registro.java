package Backend.Preguntas;

import java.io.Serializable;

/**
 * Clase que representa un registro de estadísticas para una pregunta.
 */
public class Registro implements Serializable {

    public int numeroPregunta;
    public int aciertos;
    public int desaciertos;

    /**
     * Constructor de la clase Registro.
     *
     * @param numeroPregunta el número de la pregunta
     * @param aciertos       la cantidad de aciertos
     * @param desaciertos    la cantidad de desaciertos
     */
    public Registro(int numeroPregunta, int aciertos, int desaciertos) {
        this.aciertos = aciertos;
        this.numeroPregunta = numeroPregunta;
        this.desaciertos = desaciertos;
    }

    /**
     * Obtiene una representación en cadena del objeto Registro.
     *
     * @return una cadena que representa el objeto Registro
     */
    public String toString() {
        return String.format("#p:%d a:%d d:%d", this.numeroPregunta, this.aciertos, this.desaciertos);
    }
}
