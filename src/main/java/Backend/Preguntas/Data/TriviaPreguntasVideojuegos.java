package Backend.Preguntas.Data;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public enum TriviaPreguntasVideojuegos {
    PREGUNTA1(1, "¿Cuál es el personaje principal del juego 'Super Mario Bros.' de Nintendo?", "Luigi", "Mario", "Bowser", (byte)2),
    PREGUNTA2(2, "¿En qué juego de arcade el objetivo es comer todos los puntos en un laberinto y evitar a los fantasmas?", "Space Invaders", "Pac-Man", "Donkey Kong", (byte)2),
    PREGUNTA3(3, "¿Cuál es el nombre del elfo protagonista en 'The Legend of Zelda'?", "Zelda", "Link", "Ganondorf", (byte)2),
    PREGUNTA4(4, "¿Qué juego de disparos en primera persona de id Software popularizó el género en la década de 1990?", "Half-Life", "Doom", "Quake", (byte)1),
    PREGUNTA5(5, "¿En qué juego de plataformas el personaje se enfrenta a enemigos con una espada láser?", "Sonic the Hedgehog", "Star Wars: Jedi Knight", "Mega Man", (byte)1),
    PREGUNTA6(6, "¿Cuál es el juego en el que un fontanero debe rescatar a la princesa de las garras de un monstruo tortuga?", "The Legend of Zelda", "Super Mario Bros.", "Donkey Kong", (byte)2),
    PREGUNTA7(7, "¿En qué juego el jugador asume el control de un fontanero italiano en un mundo de hongos?", "Sonic the Hedgehog", "Super Mario Bros.", "Pac-Man", (byte)1),
    PREGUNTA8(8, "¿Qué videojuego de carreras presenta a un fontanero y su hermano compitiendo en karts?", "Gran Turismo", "Mario Kart", "Need for Speed", (byte)2),
    PREGUNTA9(9, "¿Cuál es el juego en el que el personaje principal debe rescatar a la princesa Zelda de las garras de Ganon?", "Castlevania", "The Legend of Zelda", "Metroid", (byte)2),
    PREGUNTA10(10, "¿Qué juego popular de arcade presenta a un gorila llamado Donkey Kong y a un fontanero llamado Mario?", "Pac-Man", "Donkey Kong", "Galaga", (byte)2),
    PREGUNTA11(11, "¿Cuál es el nombre del protagonista que combate a las fuerzas del Dr. Robotnik en el juego 'Sonic the Hedgehog'?", "Knuckles", "Sonic", "Tails", (byte)2),
    PREGUNTA12(12, "¿En qué juego el jugador debe disparar a naves alienígenas que se desplazan horizontalmente en la pantalla?", "Asteroids", "Space Invaders", "Galaga", (byte)2),
    PREGUNTA13(13, "¿Cuál es el juego en el que el protagonista se enfrenta a enemigos en un castillo lleno de peligros?", "Contra", "Castlevania", "Metroid", (byte)2),
    PREGUNTA14(14, "¿En qué juego el jugador debe luchar contra alienígenas en una batalla por la supervivencia de la Tierra?", "Space Invaders", "Contra", "Galaga", (byte)2),
    PREGUNTA15(15, "¿Cuál es el nombre del protagonista caza demonios en la serie de juegos de Capcom?", "Link", "Dante", "Ryu", (byte)2),
    PREGUNTA16(16, "¿Qué juego de lucha presenta una serie de personajes icónicos como Ryu, Ken y Chun-Li?", "Mortal Kombat", "Street Fighter", "Tekken", (byte)2),
    PREGUNTA17(17, "¿En qué juego el jugador controla una nave espacial que dispara a oleadas de naves enemigas?", "Gradius", "Galaga", "Asteroids", (byte)2),
    PREGUNTA18(18, "¿Cuál es el nombre del cazador de tesoros que busca artefactos antiguos en la serie de juegos de 'Uncharted'?", "Lara Croft", "Nathan Drake", "Samus Aran", (byte)2),
    PREGUNTA19(19, "¿Qué juego de aventuras presenta a un personaje con una gorra roja y bigote llamado 'Guybrush Threepwood'?", "Day of the Tentacle", "Monkey Island", "Grim Fandango", (byte)2),
    PREGUNTA20(20, "¿En qué juego el jugador asume el papel de un marine espacial que lucha contra demonios en Marte?", "Wolfenstein 3D", "Doom", "Half-Life", (byte)2),
    PREGUNTA21(21, "¿Cuál es el nombre del protagonista de la serie de juegos 'Metal Gear' de Hideo Kojima?", "Liquid Snake", "Solid Snake", "Big Boss", (byte)2),
    PREGUNTA22(22, "¿En qué juego el jugador debe evitar que los fantasmas se apoderen de una pizzería?", "Slender: The Eight Pages", "Five Nights at Freddy's", "Amnesia: The Dark Descent", (byte)2),
    PREGUNTA23(23, "¿Cuál es el juego de plataformas en el que un lince lucha contra el malvado Dr. Robotnik?", "Gex", "Bubsy", "Sonic the Hedgehog", (byte)2),
    PREGUNTA24(24, "¿En qué juego de rol los jugadores asumen el papel de un joven guerrero en su búsqueda para salvar a la princesa Zelda?", "Dragon Quest", "The Legend of Zelda", "Final Fantasy", (byte)2),
    PREGUNTA25(25, "¿Qué juego de disparos en primera persona se desarrolla en la ficticia ciudad de Rapture, bajo el agua?", "Prey", "Bioshock", "System Shock", (byte)2),
    PREGUNTA26(26, "¿Cuál es el nombre del personaje principal en 'The Elder Scrolls V: Skyrim'?", "Alduin", "Dovahkiin", "Paarthurnax", (byte)2),
    PREGUNTA27(27, "¿En qué juego de aventuras los jugadores se embarcan en una búsqueda para rescatar a la princesa Peach de Bowser?", "Crash Bandicoot", "Super Mario 64", "Banjo-Kazooie", (byte)2),
    PREGUNTA28(28, "¿Cuál es el nombre del fontanero verde hermano de Mario en los juegos de Nintendo?", "Wario", "Luigi", "Toad", (byte)2),
    PREGUNTA29(29, "¿Qué juego de lucha presenta a personajes icónicos como Sub-Zero, Scorpion y Raiden?", "Killer Instinct", "Mortal Kombat", "Street Fighter", (byte)2),
    PREGUNTA30(30, "¿En qué juego de aventuras el jugador debe ayudar a Link a rescatar a la princesa Zelda y detener a Ganon?", "Chrono Trigger", "The Legend of Zelda: A Link to the Past", "Secret of Mana", (byte)2);

    private int numero;
    private String pregunta;
    private String respuestaA;
    private String respuestaB;
    private String respuestaC;
    private byte respuestaCorrecta;

    /**
     * Constructor para la enumeración Basket que inicializa una pregunta de trivia.
     *
     * @param pregunta         La descripción de la pregunta.
     * @param respuestaA          La primera opción de respuesta.
     * @param respuestaB          La segunda opción de respuesta.
     * @param respuestaC          La tercera opción de respuesta.
     * @param respuestaCorrecta   El índice de la respuesta correcta (1 para A, 2 para B, 3 para C).
     */
    private TriviaPreguntasVideojuegos(int numero, String pregunta, String respuestaA, String respuestaB, String respuestaC, byte respuestaCorrecta) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respuestaA = respuestaA;
        this.respuestaB = respuestaB;
        this.respuestaC = respuestaC;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Obtiene el número de la pregunta.
     *
     * @return El número de la pregunta.
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Obtiene el texto de la pregunta.
     *
     * @return El texto de la pregunta.
     */
    public String getPregunta() {
        return this.pregunta;
    }

    /**
     * Obtiene la primera opción de respuesta.
     *
     * @return La primera opción de respuesta.
     */
    public String getRespuestaA() {
        return this.respuestaA;
    }

    /**
     * Obtiene la segunda opción de respuesta.
     *
     * @return La segunda opción de respuesta.
     */
    public String getRespuestaB() {
        return this.respuestaB;
    }

    /**
     * Obtiene la tercera opción de respuesta.
     *
     * @return La tercera opción de respuesta.
     */
    public String getRespuestaC() {
        return this.respuestaC;
    }

    /**
     * Obtiene el índice de la respuesta correcta (1 para A, 2 para B, 3 para C).
     *
     * @return El índice de la respuesta correcta.
     */
    public byte getRespuestaCorrecta() {
        return this.respuestaCorrecta;
    }

}

