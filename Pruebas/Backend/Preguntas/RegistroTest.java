package Backend.Preguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @Test
    void testToString() {
        Registro registro = new Registro(1, 5, 2);
        assertEquals("#p:1 a:5 d:2", registro.toString());
    }
}