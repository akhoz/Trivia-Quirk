package Frontend;

import Backend.Partida.*;
import poo.proyecto2.triviaquirk.excepciones.excepcionPartidaNoDisponible;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.excepciones.excepcionRangoMayor;
import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iPregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * La clase Trivia, encargada de realizar el juego de trivia.
 */
public class Trivia {
    private Categoria categoriaRecibida;
    private String nombreCategoria;
    private Partida partida;
    private Timer timer;
    private int segundosRestantes = 20;
    private int preguntasRestantes = 30;
    private int indiceJugadores = 0;
    private int cantidadJugadores;
    private byte puntaje;
    private iPregunta pregunta;
    private ArrayList<String> categorias;
    private int indiceCategorias = 1;
    private JTextArea marcadorTextArea;

    //Declaracion---------------------------------------------------------------------------------------------------
    private JLabel preguntaLabel = new JLabel();
    private JLabel respuestaLabel = new JLabel(); //Utilizar esta como mensaje de bueno o malo (Respuesta correcta, puntos:...) o (La respuesta era: ....)
    private JLabel tiempoRestanteLabel = new JLabel();
    private JLabel turnoLabel = new JLabel();

    private JRadioButton respuestaA = new JRadioButton();
    private JRadioButton respuestaB = new JRadioButton();
    private JRadioButton respuestaC = new JRadioButton();

    private JButton siguiente = new JButton("Siguiente");

    private JPanel panelRespuestas = new JPanel(new FlowLayout());
    private ButtonGroup grupoRespuestas = new ButtonGroup();
    private JButton terminar = new JButton("Terminar");

    public Trivia(Categoria categoria, Partida partida) {
        this.partida = partida;
        this.categoriaRecibida = categoria;
        this.cantidadJugadores = partida.getJugadores().size();
        this.nombreCategoria = categoria.nombreCategoria();
        this.categorias = new ArrayList<>(categoria.getCategorias());
        categoria.limpiarCategorias();

        marcadorTextArea = new JTextArea();
        marcadorTextArea.setEditable(false);
        marcadorTextArea.setFocusable(false);
        marcadorTextArea.setBackground(null);
        marcadorTextArea.setOpaque(false);
        actualizarMarcador();

        JScrollPane marcadorScrollPane = new JScrollPane(marcadorTextArea);
        marcadorScrollPane.setBounds(900, 500, 250, 200);

        //Ventana-------------------------------------------------------------------------------------------------------
        JFrame ventana = new JFrame("Trivia Quirk");
        ventana.setSize(1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(marcadorScrollPane);

        //Fuentes-------------------------------------------------------------------------------------------------------
        Font fuente = new Font("Arial", Font.BOLD, 15);
        Font fuenteSecundaria = new Font("Arial", Font.PLAIN, 8);

        //Implementacion------------------------------------------------------------------------------------------------
        turnoLabel.setBounds(10, 10, 600, 30);
        turnoLabel.setFont(fuente);
        turnoLabel.setText("Turno de: " + partida.getNombreJugadores().get(0));
        ventana.add(turnoLabel);

        tiempoRestanteLabel.setBounds(10, 50, 600, 30);
        tiempoRestanteLabel.setFont(fuente);
        tiempoRestanteLabel.setText("Tiempo restante: 20 segundos");
        ventana.add(tiempoRestanteLabel);

        preguntaLabel.setBounds(10, 170, 1200, 30);
        preguntaLabel.setFont(fuente);

        //respuestaA.setBounds(10, 130, 800, 30);
        respuestaA.setFont(fuente);

        //respuestaB.setBounds(270, 130, 800, 30);
        respuestaB.setFont(fuente);

        //respuestaC.setBounds(540, 130, 800, 30);
        respuestaC.setFont(fuente);

        try {
            pregunta = categoria.obtenerPreguntaAleatoria(partida.getNumeroPartida());
            preguntaLabel.setText(pregunta.obtenerDescripcion());
            respuestaA.setText(pregunta.obtenerRespuesta1());
            respuestaB.setText(pregunta.obtenerRespuesta2());
            respuestaC.setText(pregunta.obtenerRespuesta3());

        } catch (excepcionPreguntasNoDisponibles e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error");
            e.printStackTrace();
        }
        ventana.add(preguntaLabel);

        panelRespuestas.setBounds(10, 210, 1100, 50);
        panelRespuestas.add(respuestaA);
        panelRespuestas.add(respuestaB);
        panelRespuestas.add(respuestaC);
        grupoRespuestas.add(respuestaA);
        grupoRespuestas.add(respuestaB);
        grupoRespuestas.add(respuestaC);
        ventana.add(panelRespuestas);

        respuestaLabel.setVisible(false);
        respuestaLabel.setBounds(10, 300, 400, 30);
        respuestaLabel.setFont(fuente);
        ventana.add(respuestaLabel);

        siguiente.setVisible(false);
        terminar.setVisible(false);
        siguiente.setBounds(10, 727, 100,30);
        terminar.setBounds(140, 727, 100,30);
        ventana.add(siguiente);
        ventana.add(terminar);

        //Acciones------------------------------------------------------------------------------------------------------
        /**
         * Inicializa y comienza el temporizador para el tiempo de respuesta.
         */
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                segundosRestantes--;

                if (segundosRestantes >= 0) {
                    tiempoRestanteLabel.setText("Tiempo restante: " + segundosRestantes + " segundos");
                } else {
                    tiempoRestanteLabel.setText("¡Tiempo agotado!");
                    siguiente.setVisible(true);
                    puntaje = 0;
                    try {
                        pregunta.esCorrecta(puntaje);
                    } catch (excepcionRangoMayor | FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    timer.stop();
                }
            }
        });
        timer.start();

        /**
         * Configura la acción realizada al hacer clic en la opción de respuesta A.
         */
        respuestaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuestaA.setEnabled(false);
                respuestaB.setEnabled(false);
                respuestaC.setEnabled(false);
                siguiente.setVisible(true);
                terminar.setVisible(true);
                timer.stop();

                byte valorSeleccionado = 1;
                System.out.println(pregunta.obtenerDescripcion() + " respuesta seleccionada: " + valorSeleccionado);

                try {
                    puntaje = pregunta.esCorrecta(valorSeleccionado);
                    System.out.println("Puntos obtenidos: " + puntaje);

                    if (puntaje != 0) {
                        partida.getJugadores().get(indiceJugadores).aumentarPuntaje(puntaje);
                        respuestaLabel.setText("Respuesta correcta, has obtenido " + puntaje + " puntos!");
                        respuestaLabel.setVisible(true);
                        actualizarMarcador();
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    } else {
                        respuestaLabel.setText("Respuesta incorrecta");
                        respuestaLabel.setVisible(true);
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    }

                } catch (excepcionRangoMayor | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        /**
         * Configura la acción realizada al hacer clic en la opción de respuesta B.
         */
        respuestaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuestaA.setEnabled(false);
                respuestaB.setEnabled(false);
                respuestaC.setEnabled(false);
                siguiente.setVisible(true);
                terminar.setVisible(true);
                timer.stop();

                byte valorSeleccionado = 2;
                System.out.println(pregunta.obtenerDescripcion() + " respuesta seleccionada: " + valorSeleccionado);

                try {
                    puntaje = pregunta.esCorrecta(valorSeleccionado);
                    System.out.println("Puntos obtenidos: " + puntaje);

                    if (puntaje != 0) {
                        partida.getJugadores().get(indiceJugadores).aumentarPuntaje(puntaje);
                        respuestaLabel.setText("Respuesta correcta, has obtenido " + puntaje + " puntos!");
                        respuestaLabel.setVisible(true);
                        actualizarMarcador();
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    } else {
                        respuestaLabel.setText("Respuesta incorrecta");
                        respuestaLabel.setVisible(true);
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    }

                } catch (excepcionRangoMayor | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        /**
         * Configura la acción realizada al hacer clic en la opción de respuesta C.
         */
        respuestaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respuestaA.setEnabled(false);
                respuestaB.setEnabled(false);
                respuestaC.setEnabled(false);
                siguiente.setVisible(true);
                terminar.setVisible(true);
                timer.stop();

                byte valorSeleccionado = 3;
                System.out.println(pregunta.obtenerDescripcion() + " respuesta seleccionada: " + valorSeleccionado);

                try {
                    puntaje = pregunta.esCorrecta(valorSeleccionado);
                    System.out.println("Puntos obtenidos: " + puntaje);

                    if (puntaje != 0) {
                        partida.getJugadores().get(indiceJugadores).aumentarPuntaje(puntaje);
                        respuestaLabel.setText("Respuesta correcta, has obtenido " + puntaje + " puntos!");
                        respuestaLabel.setVisible(true);
                        actualizarMarcador();
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    } else {
                        respuestaLabel.setText("Respuesta incorrecta");
                        respuestaLabel.setVisible(true);
                        //VOLVER A OBTENER PREGUNTA ALEATORIA
                    }

                } catch (excepcionRangoMayor | FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        /**
         * Configura la acción realizada al hacer clic en el botón "Siguiente" para avanzar a la siguiente pregunta.
         */
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (preguntasRestantes == 1) {
                    System.out.println("--------------------------------------------------");
                    System.out.println(indiceCategorias);
                    System.out.println(categorias.size());
                    System.out.println("--------------------------------------------------");
                    if (indiceCategorias < categorias.size()) {
                        categoria.setCategoria(categorias.get(indiceCategorias));
                        nombreCategoria = categorias.get(indiceCategorias);
                        partida.limpiarPreguntasRealizadas();
                        categoria.obtenerPartida(partida.getNumeroPartida()).limpiarPreguntasRealizadas();
                        ++indiceCategorias;
                        preguntasRestantes = 30;
                        obtenerYMostrarNuevaPregunta();
                        siguiente.setVisible(false);
                    } else {
                        System.out.println(indiceCategorias);
                        try {
                            categoria.finalizarPartida(partida.getNumeroPartida());
                        } catch (excepcionPartidaNoDisponible ex) {
                            throw new RuntimeException(ex);
                        }
                        mostrarGanador();
                        MenuPrincipal.getInstance().setVisible(true);
                        ventana.dispose();
                    }
                } else {
                    categoria.setCategoria(nombreCategoria);
                    obtenerYMostrarNuevaPregunta();
                    siguiente.setVisible(false);
                }
            }
        });

        /**
         * Configura la acción realizada al hacer clic en el botón "Terminar" para finalizar la partida.
         */
        terminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGanador();
                try {
                    categoria.finalizarPartida(partida.getNumeroPartida());
                } catch (excepcionPartidaNoDisponible ex) {
                    throw new RuntimeException(ex);
                }
                MenuPrincipal.getInstance().setVisible(true);
                ventana.dispose();
            }
        });


        //Ventana------------------------------------------------------------------------------------------------------
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);

    }

    /**
     * Obtiene y muestra una nueva pregunta aleatoria para la partida actual.
     * Actualiza la interfaz gráfica con la descripción y opciones de respuesta de la nueva pregunta,
     * inicia el temporizador y realiza las configuraciones necesarias para el próximo turno.
     */
    private void obtenerYMostrarNuevaPregunta() {
        try {
            pregunta = categoriaRecibida.obtenerPreguntaAleatoria(partida.getNumeroPartida());
            preguntaLabel.setText(pregunta.obtenerDescripcion());
            respuestaA.setText(pregunta.obtenerRespuesta1());
            respuestaB.setText(pregunta.obtenerRespuesta2());
            respuestaC.setText(pregunta.obtenerRespuesta3());
            respuestaLabel.setVisible(false);

            segundosRestantes = 20;

            grupoRespuestas.clearSelection();

            respuestaA.setEnabled(true);
            respuestaB.setEnabled(true);
            respuestaC.setEnabled(true);

            timer.restart();

            --preguntasRestantes;
            System.out.println("Preguntas restantes: " + preguntasRestantes);

            ++indiceJugadores;

            if (indiceJugadores == cantidadJugadores) {
                indiceJugadores = 0;
            }

            turnoLabel.setText("Turno de: " + partida.getNombreJugadores().get(indiceJugadores));
            System.out.println("Turno de: " + partida.getNombreJugadores().get(indiceJugadores));

        } catch (excepcionPreguntasNoDisponibles e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la nueva pregunta");
            e.printStackTrace();
        }
    }

    /**
     * Actualiza el marcador mostrando el puntaje actual de cada jugador en la interfaz gráfica.
     */
    private void actualizarMarcador() {
        ArrayList<iJugador> jugadores = partida.getJugadores();
        StringBuilder marcadorText = new StringBuilder("Marcador Actual:\n");

        for (iJugador jugador : jugadores) {
            marcadorText.append(String.format("%s:\t\t%d\n", jugador.obtenerNombreJugador(), jugador.obtenerPuntaje()));
        }

        marcadorTextArea.setText(marcadorText.toString());
    }

    /**
     * Muestra el resultado final del juego, incluyendo el orden de los jugadores por puntaje.
     * En caso de un solo jugador, muestra un mensaje de felicitaciones.
     */
    private void mostrarGanador() {
        ArrayList<iJugador> jugadores = partida.getJugadores();

        if (jugadores.size() == 1) {
            JOptionPane.showMessageDialog(null, "Haz obtenido " + jugadores.get(0).obtenerPuntaje() + " puntos, felicidades!",
                    "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Ordena la lista de jugadores por puntaje de mayor a menor.
        Collections.sort(jugadores, Comparator.comparingInt(iJugador::obtenerPuntaje).reversed());

        StringBuilder mensaje = new StringBuilder("¡Orden de los jugadores por puntaje:\n");

        for (int i = 0; i < jugadores.size(); i++) {
            iJugador jugador = jugadores.get(i);
            mensaje.append(i + 1).append(". ").append(jugador.obtenerNombreJugador())
                    .append(" - Puntaje: ").append(jugador.obtenerPuntaje()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
    }
}
