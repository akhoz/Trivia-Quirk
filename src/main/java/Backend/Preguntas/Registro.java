package Backend.Preguntas;

import java.io.Serializable;
public class Registro implements Serializable {
    public int numeroPregunta;
    public int aciertos;
    public int desaciertos;

    public Registro(int numeroPregunta, int aciertos, int desaciertos) {
        this.aciertos = aciertos;
        this.numeroPregunta = numeroPregunta;
        this.desaciertos = desaciertos;
    }

    public String toString() {
        return String.format("#p:%d a:%d d:%d", this.numeroPregunta, this.aciertos, this.desaciertos);
    }
}
