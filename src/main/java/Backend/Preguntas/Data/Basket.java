package Backend.Preguntas.Data;

import java.util.ArrayList;

public enum Basket {
    PREGUNTA_1("¿Qué equipo de la NBA tiene el récord de más campeonatos de la NBA?", "Boston Celtics", "Los Angeles Lakers", "Chicago Bulls", (byte) 1),
    PREGUNTA_2("¿Quién es conocido como 'La Mamba Negra' y tuvo una carrera legendaria con los Los Angeles Lakers?", "LeBron James", "Shaquille O'Neal", "Kobe Bryant", (byte) 3),
    PREGUNTA_3("¿Cuál es el término para un lanzamiento exitoso que resulta en una puntuación de tres puntos en la NBA?", "Layup", "Tiro libre", "Triple", (byte) 3),
    PREGUNTA_4("¿Qué equipo seleccionó a LeBron James como la primera selección general en el Draft de la NBA de 2003?", "Cleveland Cavaliers", "Miami Heat", "Los Angeles Lakers", (byte) 1),
    PREGUNTA_5("¿Cuántos jugadores hay en la cancha para cada equipo durante un juego de la NBA?", "5", "6", "7", (byte) 1),
    PREGUNTA_6("¿Quién es el máximo anotador de todos los tiempos en la historia de la NBA?", "Michael Jordan", "Kareem Abdul-Jabbar", "Shaquille O'Neal", (byte) 2),
    PREGUNTA_7("¿Qué equipo ha ganado la mayoría de los campeonatos de la NBA hasta 2023?", "Golden State Warriors", "Los Angeles Lakers", "Boston Celtics", (byte) 3),
    PREGUNTA_8("¿Cuál es el término para un lanzamiento en baloncesto donde un jugador salta y anota al poner la pelota directamente en la canasta con una o ambas manos?", "Layup", "Tiro libre", "Mate", (byte) 3),
    PREGUNTA_9("¿Qué jugador de la NBA es conocido por su tiro característico 'Sky Hook'?", "LeBron James", "Shaquille O'Neal", "Kareem Abdul-Jabbar", (byte) 3),
    PREGUNTA_10("¿Cuál es el término para una falta en baloncesto donde un jugador está intentando anotar cuando lo derriban, y se le otorgan tiros libres?", "Falta técnica", "Falta flagrante", "Falta en lanzamiento", (byte) 3),
    PREGUNTA_11("¿Qué equipo de la NBA también es conocido como los 'Dubs'?", "Los Angeles Lakers", "Golden State Warriors", "Houston Rockets", (byte) 2),
    PREGUNTA_12("En baloncesto, ¿qué significa 'NBA'?", "Asociación Nacional de Baloncesto", "Asociación Nacional de Béisbol", "Alianza Nacional de Baloncesto", (byte) 1),
    PREGUNTA_13("¿Quién ganó el premio MVP de la NBA para la temporada 2021-2022?", "LeBron James", "Kevin Durant", "Stephen Curry", (byte) 3),
    PREGUNTA_14("¿Cuál es el término para la zona en la cancha de baloncesto donde un jugador lanza tiros libres?", "Área pintada", "Perímetro", "Línea de falta", (byte) 3),
    PREGUNTA_15("¿Quién es el entrenador en jefe de los Los Angeles Lakers en 2023?", "Steve Kerr", "Tyronn Lue", "Frank Vogel", (byte) 3),
    PREGUNTA_16("¿Qué jugador es conocido por su carrera con el Miami Heat y su apodo 'Flash'?", "Dwyane Wade", "Chris Bosh", "Ray Allen", (byte) 1),
    PREGUNTA_17("¿Cuál es el término para un lanzamiento exitoso que resulta en una puntuación de dos puntos en la NBA?", "Layup", "Tiro libre", "Mate", (byte) 1),
    PREGUNTA_18("¿Qué equipo de la NBA ganó las Finales de la NBA de 2021?", "Los Angeles Lakers", "Brooklyn Nets", "Milwaukee Bucks", (byte) 3),
    PREGUNTA_19("¿Quién tiene el récord de la mayor cantidad de puntos anotados en un solo juego de la NBA con 100 puntos?", "Kobe Bryant", "Wilt Chamberlain", "Michael Jordan", (byte) 2),
    PREGUNTA_20("¿Qué jugador es conocido por su increíble capacidad para bloquear tiros y jugó para los Houston Rockets y Los Angeles Lakers?", "Hakeem Olajuwon", "Kareem Abdul-Jabbar", "Shaquille O'Neal", (byte) 1),
    PREGUNTA_21("¿Quién es el líder de todos los tiempos en asistencias en la NBA?", "Magic Johnson", "John Stockton", "Chris Paul", (byte) 2),
    PREGUNTA_22("¿Qué jugador de la NBA es conocido por su movimiento 'Dream Shake' en la zona?", "Michael Jordan", "Kareem Abdul-Jabbar", "Hakeem Olajuwon", (byte) 3),
    PREGUNTA_23("¿Qué equipo de baloncesto universitario es conocido por su 'Fab Five' de principios de la década de 1990?", "Duke Blue Devils", "Kentucky Wildcats", "Michigan Wolverines", (byte) 3),
    PREGUNTA_24("¿Cuál es el término para una jugada defensiva en baloncesto donde un jugador salta para bloquear o alterar el tiro de un oponente?", "Robo", "Bloqueo", "Rebote", (byte) 2),
    PREGUNTA_25("¿Quién es conocido por su increíble capacidad de anotación y a menudo se le llama 'La Respuesta'?", "LeBron James", "Kobe Bryant", "Allen Iverson", (byte) 3),
    PREGUNTA_26("¿Cuál es el término para una violación en baloncesto donde un jugador da un número excesivo de pasos sin botar el balón?", "Doble dribble", "Pasos", "Palmada", (byte) 2),
    PREGUNTA_27("¿Qué jugador de la NBA es conocido por su increíble capacidad atlética y clavadas espectaculares y jugó para el Orlando Magic y los Los Angeles Lakers?", "Kareem Abdul-Jabbar", "Dwight Howard", "Tim Duncan", (byte) 2),
    PREGUNTA_28("¿Quién es conocido por su increíble habilidad para anotar y a menudo se le llama 'La Durantula'?", "LeBron James", "Kobe Bryant", "Stephen Curry", (byte) 3),
    PREGUNTA_29("¿Qué equipo de la NBA es a menudo llamado los 'Dubs' y es conocido por su pareja de tiradores conocida como los 'Splash Brothers'?", "Los Angeles Lakers", "Golden State Warriors", "Miami Heat", (byte) 3),
    PREGUNTA_30("¿Qué pasa si patea una pelota en baloncesto?", "No pasa nada", "Se considera falta", "Se acaba el juego", (byte) 2);

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
    Basket(String descripcion, String respuestaA, String respuestaB, String respuestaC, byte respuestaCorrecta) {
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
