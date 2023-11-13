package Backend.Preguntas;

import java.util.ArrayList;

public enum Futbol {
    PREGUNTA_1("¿Cuántas veces ha ganado Lionel Messi la UEFA Champions League?", "3", "4", "5", (byte) 2),
    PREGUNTA_2("¿Cuántos títulos de la UEFA Champions League ha ganado Cristiano Ronaldo?", "3", "4", "5", (byte) 3),
    PREGUNTA_3("¿Cuántas veces ha ganado el Real Madrid la UEFA Champions League?", "12", "13", "14", (byte) 3),
    PREGUNTA_4("¿Quién es el jugador que anotó 5 goles en 9 minutos?", "Lionel Messi", "Robert Lewandowski", "Cristiano Ronaldo", (byte) 2),
    PREGUNTA_5("¿Cuántas veces ha ganado la selección nacional de Argentina la Copa Mundial de la FIFA?", "1", "2", "3", (byte) 3),
    PREGUNTA_6("¿Quién es el máximo goleador de todos los tiempos en la UEFA Champions League?", "Lionel Messi", "Cristiano Ronaldo", "Raúl", (byte) 2),
    PREGUNTA_7("¿Qué país organizó la Copa Mundial de la FIFA 2018?", "Francia", "Alemania", "Rusia", (byte) 3),
    PREGUNTA_8("¿Quién es el entrenador del Manchester City en 2023?", "Pep Guardiola", "Jurgen Klopp", "Zinedine Zidane", (byte) 1),
    PREGUNTA_9("¿Qué país ganó la Eurocopa 2021 (Euro 2020)?", "Alemania", "Italia", "España", (byte) 2),
    PREGUNTA_10("¿Cuántas veces ha ganado Brasil la Copa Mundial de la FIFA?", "4", "5", "6", (byte) 2),
    PREGUNTA_11("¿Quién ganó el Balón de Oro 2023?", "Lionel Messi", "Erling Haaland", "Kylian Mbappé", (byte) 1),
    PREGUNTA_12("¿Qué club ganó la mayoría de los títulos consecutivos de la UEFA Champions League de 1956 a 1957?", "Real Madrid", "AC Milan", "FC Barcelona", (byte) 1),
    PREGUNTA_13("¿Quién ganó la Copa Mundial de la FIFA en 2014?", "Alemania", "Brasil", "Argentina", (byte) 1),
    PREGUNTA_14("¿Qué nación ganó la Copa Mundial de la FIFA en 1966?", "Inglaterra", "Portugal", "Francia", (byte) 1),
    PREGUNTA_15("¿Quién es el máximo goleador de todos los tiempos de la selección nacional francesa?", "Zinedine Zidane", "Thierry Henry", "Michel Platini", (byte) 2),
    PREGUNTA_16("¿En qué año Francia fue el país anfitrión y ganó la Copa Mundial de la FIFA?", "1994", "1998", "2002", (byte) 2),
    PREGUNTA_17("¿Qué club italiano ha ganado la mayoría de los títulos de la Serie A?", "Juventus", "AC Milan", "Inter Milan", (byte) 1),
    PREGUNTA_18("¿Cuántas veces ha ganado España la Eurocopa de la UEFA?", "1", "2", "3", (byte) 3),
    PREGUNTA_19("¿Quién es el máximo goleador de todos los tiempos de la selección nacional española?", "Iker Casillas", "Fernando Torres", "Raúl", (byte) 3),
    PREGUNTA_20("¿Quién fue el máximo goleador en la UEFA Champions League de 2023?", "Lionel Messi", "Olivier Giroud", "Kylian Mbappé", (byte) 3),
    PREGUNTA_21("¿Qué equipo tiene como estadio local San Siro?", "Manchester United", "Juventus", "AC Milan", (byte) 3),
    PREGUNTA_22("¿En qué club portugués jugó Cristiano Ronaldo antes de mudarse al Manchester United?", "Sporting CP", "Benfica", "FC Porto", (byte) 1),
    PREGUNTA_23("¿En qué ciudad se encuentra el estadio Camp Nou?", "Madrid", "Milán", "Barcelona", (byte) 3),
    PREGUNTA_24("¿Qué club inglés ganó la primera edición de la Premier League en la temporada 1992-1993?", "Liverpool", "Arsenal", "Manchester United", (byte) 3),
    PREGUNTA_25("¿Cuántas veces ha ganado la selección nacional de los Países Bajos la Copa Mundial de la FIFA?", "0", "1", "2", (byte) 1),
    PREGUNTA_26("¿Quién es el máximo goleador de todos los tiempos de la selección nacional alemana?", "Miroslav Klose", "Gerd Muller", "Lukas Podolski", (byte) 1),
    PREGUNTA_27("¿Cuántas veces ha ganado el AC Milan la UEFA Champions League?", "5", "6", "7", (byte) 3),
    PREGUNTA_28("¿Qué club español ganó la primera edición de la UEFA Champions League en 1956?", "Real Madrid", "FC Barcelona", "Atletico Madrid", (byte) 1),
    PREGUNTA_29("¿Cuántas veces ha ganado Inglaterra la Copa Mundial de la FIFA?", "0", "1", "2", (byte) 2),
    PREGUNTA_30("¿Qué club italiano tiene más títulos de la UEFA Champions League en su haber?", "AC Milan", "Inter Milan", "AS Roma", (byte) 1);

    private final String descripcion;
    private final ArrayList<String> respuestas = new ArrayList<>();
    private final byte respuestaCorrecta;

    Futbol(String descripcion, String respuestaA, String respuestaB, String respuestaC, byte respuestaCorrecta) {
        this.descripcion = descripcion;
        this.respuestas.add(respuestaA);
        this.respuestas.add(respuestaB);
        this.respuestas.add(respuestaC);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getRespuestaA() {
        return this.respuestas.get(0);
    }

    public String getRespuestaB() {
        return this.respuestas.get(1);
    }

    public String getRespuestaC() {
        return this.respuestas.get(2);
    }

    public byte getRespuestaCorrecta() {
        return this.respuestaCorrecta;
    }

}