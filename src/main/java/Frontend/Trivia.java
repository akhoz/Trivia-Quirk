package Frontend;

import Backend.Partida.*;
import poo.proyecto2.triviaquirk.excepciones.excepcionPreguntasNoDisponibles;
import poo.proyecto2.triviaquirk.iPregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Trivia {
    private Categoria categoria;
    private Partida partida;
    private Timer timer;
    private int segundosRestantes = 20;
    private iPregunta pregunta;

    public Trivia(Categoria categoria, Partida partida) {
        //Ventana-------------------------------------------------------------------------------------------------------
        JFrame ventana = new JFrame("Trivia Quirk");
        ventana.setSize(1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Fuentes-------------------------------------------------------------------------------------------------------
        Font fuente = new Font("Arial", Font.BOLD, 15);
        Font fuenteSecundaria = new Font("Arial", Font.PLAIN, 8);

        //Declaracion---------------------------------------------------------------------------------------------------
        JLabel preguntaLabel = new JLabel();
        JLabel respuestaLabel = new JLabel(); //Utilizar esta como mensaje de bueno o malo (Respuesta correcta, puntos:...) o (La respuesta era: ....)
        JLabel tiempoRestanteLabel = new JLabel();
        JLabel turnoLabel = new JLabel();

        JRadioButton respuestaA = new JRadioButton();
        JRadioButton respuestaB = new JRadioButton();
        JRadioButton respuestaC = new JRadioButton();

        JPanel panelRespuestas = new JPanel(new FlowLayout());

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
        ventana.add(panelRespuestas);

        // Inicialización y configuración del Timer
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                segundosRestantes--;

                if (segundosRestantes >= 0) {
                    tiempoRestanteLabel.setText("Tiempo restante: " + segundosRestantes + " segundos");
                } else {
                    tiempoRestanteLabel.setText("¡Tiempo agotado!");
                    // Realizar acciones adicionales cuando se agota el tiempo, por ejemplo, finalizar la trivia.
                    timer.stop(); // Detener el timer cuando el tiempo se agota.
                }
            }
        });
        timer.start();

        //Ventana------------------------------------------------------------------------------------------------------
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }
}
