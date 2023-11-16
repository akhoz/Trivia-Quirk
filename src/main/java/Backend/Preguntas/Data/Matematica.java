package Backend.Preguntas.Data;

import java.util.ArrayList;
public enum Matematica {
        PREGUNTA_1("Calcular la derivada de ln(x)", "1/x", "x", "2/x", (byte) 1),
        PREGUNTA_2("Encontrar la antiderivada de dx", "x", "1/x", "x^2", (byte) 1),
        PREGUNTA_3("Calcular el valor de x cuando x - 2 = 3", "5", "2", "3", (byte) 2),
        PREGUNTA_4("Calcular el límite de (x^2 - 1) / (x - 1) cuando x se aproxima a 1", "0", "2", "Indefinido", (byte) 3),
        PREGUNTA_5("Encontrar la derivada de 3x^2 - 4x + 2", "6x - 4", "3x^3 - 4x + 2", "2x^2 - 4", (byte) 1),
        PREGUNTA_6("Calcular la antiderivada de 2x + 3", "x^2 + 3x + C", "2x^2 + 3x", "x + 3", (byte) 1),
        PREGUNTA_7("¿Cuánto es 5 + 7?", "10", "12", "14", (byte) 2),
        PREGUNTA_8("Simplificar la expresión: 2(3x + 4) - (x - 2)", "3x + 6", "x + 2", "6x + 2", (byte) 2),
        PREGUNTA_9("Encontrar la raíz cuadrada de 16", "4", "8", "3", (byte) 1),
        PREGUNTA_10("Evaluar 3^2", "6", "9", "27", (byte) 2),
        PREGUNTA_11("Calcular el producto de 4 y 7", "28", "44", "7", (byte) 1),
        PREGUNTA_12("Restar 9 de 15", "6", "4", "15", (byte) 1),
        PREGUNTA_13("Encontrar la derivada de sin(x)", "cos(x)", "tan(x)", "csc(x)", (byte) 1),
        PREGUNTA_14("Calcular la antiderivada de 5x^4", "5x^5 + C", "20x^3 + C", "x^5 + C", (byte) 3),
        PREGUNTA_15("¿Cuál es el resultado de 12 dividido por 4?", "8", "4", "3", (byte) 3),
        PREGUNTA_16("Simplificar: 2x + 3x", "5x", "x^2", "2x^2", (byte) 1),
        PREGUNTA_17("Encontrar el límite de (1/x) cuando x se aproxima a infinito", "0", "Infinito", "Indefinido", (byte) 1),
        PREGUNTA_18("Calcular la derivada de 4x^3 - 2x^2", "12x^2 - 4x", "8x^2 - 2x", "4x^2 - 2x", (byte) 1),
        PREGUNTA_19("Evaluar 5^3", "125", "8", "35", (byte) 1),
        PREGUNTA_20("¿Cuál es la raíz cuadrada de 25?", "5", "7", "6", (byte) 1),
        PREGUNTA_21("Sumar 8 y 6", "14", "2", "6", (byte) 1),
        PREGUNTA_22("Restar 3 de 9", "6", "4", "9", (byte) 1),
        PREGUNTA_23("Encontrar la derivada de cos(x)", "-sin(x)", "-csc(x)", "tan(x)", (byte) 1),
        PREGUNTA_24("Calcular la antiderivada de 3x^2 + 4x", "x^3 + 2x^2 + C", "x^2 + 2x + C", "6x^2 + 4x + C", (byte) 1),
        PREGUNTA_25("¿Cuánto es 18 dividido por 2?", "16", "2", "18", (byte) 2),
        PREGUNTA_26("Simplificar: 4x + 2x", "6x", "2x^2", "6x^2", (byte) 1),
        PREGUNTA_27("Encontrar el límite de (1/x) cuando x se aproxima a 0", "0", "Infinito", "Indefinido", (byte) 3),
        PREGUNTA_28("Calcular la derivada de 2x^2 - 3x", "4x - 3", "2x - 3", "2x^2 - 3x^2", (byte) 1),
        PREGUNTA_29("Evaluar 4^3", "16", "64", "8", (byte) 3),
        PREGUNTA_30("¿Cuál es la raíz cuadrada de 36?", "6", "7", "5", (byte) 1);

        private final String descripcion;
        private final ArrayList<String> respuestas = new ArrayList<>();
        private final byte respuestaCorrecta;

        /**
         * Constructor para la enumeración Basket que inicializa una pregunta de trivia.
         *
         * @param descripcion         La descripción de la pregunta.
         * @param respuestaA          La primera opción de respuesta.
         * @param respuestaB          La segunda opción de respuesta.
         * @param respuestaC          La tercera opción de respuesta.
         * @param respuestaCorrecta   El índice de la respuesta correcta (1 para A, 2 para B, 3 para C).
         */
        Matematica(String descripcion, String respuestaA, String respuestaB, String respuestaC, byte respuestaCorrecta) {
            this.descripcion = descripcion;
            this.respuestas.add(respuestaA);
            this.respuestas.add(respuestaB);
            this.respuestas.add(respuestaC);
            this.respuestaCorrecta = respuestaCorrecta;
        }

        /**
         * Obtiene la descripción de la pregunta.
         * @return La descripción de la pregunta.
         */
        public String getDescripcion() {
                return this.descripcion;
        }

        /**
         * Obtiene la primera opción de respuesta.
         * @return La primera opción de respuesta.
         */
        public String getRespuestaA() {
                return this.respuestas.get(0);
        }

        /**
         * Obtiene la segunda opción de respuesta.
         * @return La segunda opción de respuesta.
         */
        public String getRespuestaB() {
                return this.respuestas.get(1);
        }

        /**
         * Obtiene la tercera opción de respuesta.
         * @return La tercera opción de respuesta.
         */
        public String getRespuestaC() {
                return this.respuestas.get(2);
        }

        /**
         * Obtiene el índice de la respuesta correcta.
         * @return El índice de la respuesta correcta.
         */
        public byte getRespuestaCorrecta() {
                return this.respuestaCorrecta;
        }
}
