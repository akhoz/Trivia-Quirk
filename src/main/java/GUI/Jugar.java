package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Jugar extends JFrame {

    public Jugar() {
        //Ventana------------------------------------------------------------------------------------------------------
        JFrame ventana = new JFrame("Registrando jugadores");
        ventana.setSize(600, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Fuentes-------------------------------------------------------------------------------------------------------
        Font fuente = new Font("Arial", Font.BOLD, 15);
        Font fuenteSecundaria = new Font("Arial", Font.PLAIN, 8);

        //Declaracion---------------------------------------------------------------------------------------------------
        JLabel cantidadJugadoresLabel = new JLabel();
        JLabel nombreJugadorLabel = new JLabel();

        JTextField cantidadJugadores = new JTextField();
        JTextField nombreJugador = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton registrar = new JButton("Registrar");
        JButton regresar = new JButton("Regresar");

        //Implementacion------------------------------------------------------------------------------------------------
        cantidadJugadoresLabel.setBounds(10, 10, 200, 30);
        cantidadJugadoresLabel.setFont(fuente);
        cantidadJugadoresLabel.setText("Cantidad de jugadores");
        ventana.add(cantidadJugadoresLabel);

        cantidadJugadores.setBounds(190, 10, 100, 30);
        cantidadJugadores.setFont(fuenteSecundaria);
        setPlaceholder(cantidadJugadores, "Cantidad de jugadores");
        ventana.add(cantidadJugadores);

        confirmar.setBounds(300, 10, 100, 30);
        ventana.add(confirmar);

        regresar.setBounds(5, 227, 100, 30);
        ventana.add(regresar);

        nombreJugadorLabel.setVisible(false);
        nombreJugadorLabel.setBounds(10, 50, 200, 30);
        nombreJugadorLabel.setFont(fuente);
        nombreJugadorLabel.setText("Nombre del jugador");
        ventana.add(nombreJugadorLabel);

        nombreJugador.setVisible(false);
        nombreJugador.setBounds(190, 50, 100, 30);
        nombreJugador.setFont(fuenteSecundaria);
        setPlaceholder(nombreJugador, "Nombre del jugador");
        ventana.add(nombreJugador);

        registrar.setVisible(false);
        registrar.setBounds(300, 50, 100, 30);
        ventana.add(registrar);

        //Acciones------------------------------------------------------------------------------------------------------
        confirmar.addActionListener(e -> {
            String input = cantidadJugadores.getText();

            if (input.equals("Cantidad de jugadores") || input.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de jugadores");
            } else {
                try {
                    int cantidad = Integer.parseInt(input);

                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a 0");
                    } else {
                        System.out.println("Cantidad de jugadores: " + cantidad);

                        cantidadJugadoresLabel.setFocusable(false);
                        cantidadJugadores.setFocusable(false);
                        confirmar.setEnabled(false);

                        nombreJugadorLabel.setVisible(true);
                        nombreJugador.setVisible(true);
                        registrar.setVisible(true);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
                }
            }
        });

        registrar.addActionListener(e -> {
            String input = nombreJugador.getText();

            if (input.equals("Nombre del jugador") || input.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del jugador");
            } else {
                System.out.println("Nombre del jugador: " + input);
                nombreJugador.setText("");
            }
        });

        regresar.addActionListener(e -> {
            System.out.println("Regresando a la ventana principal");
            ventana.dispose();
            Home.getInstance();
        });


        //Ventana------------------------------------------------------------------------------------------------------
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }

    private void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}
