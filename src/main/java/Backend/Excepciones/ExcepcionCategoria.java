package Backend.Excepciones;

public class ExcepcionCategoria extends Exception{
    public ExcepcionCategoria(){
        super("Hubo un error, nombre de la categoria invalido");
    }
}
