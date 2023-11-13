package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Jugar extends JFrame {

    private int cantidad;

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
        JLabel jugadoresRestantes = new JLabel();
        JLabel categoriasDisponibles = new JLabel();
        JLabel categoriaLabel = new JLabel();

        JTextField cantidadJugadores = new JTextField();
        JTextField nombreJugador = new JTextField();
        JTextField categoria = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton registrar = new JButton("Registrar");
        JButton regresar = new JButton("Regresar");
        JButton jugar = new JButton("Jugar");


        //Implementacion------------------------------------------------------------------------------------------------
        cantidadJugadoresLabel.setBounds(10, 10, 200, 30);
        cantidadJugadoresLabel.setFont(fuente);
        cantidadJugadoresLabel.setText("Cantidad de jugadores: ");
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
        nombreJugadorLabel.setText("Nombre del jugador: ");
        ventana.add(nombreJugadorLabel);

        nombreJugador.setVisible(false);
        nombreJugador.setBounds(190, 50, 100, 30);
        nombreJugador.setFont(fuenteSecundaria);
        setPlaceholder(nombreJugador, "Nombre del jugador");
        ventana.add(nombreJugador);

        registrar.setVisible(false);
        registrar.setBounds(300, 50, 100, 30);
        ventana.add(registrar);

        jugadoresRestantes.setVisible(false);
        jugadoresRestantes.setBounds(10, 90, 200, 30);
        jugadoresRestantes.setFont(fuente);
        ventana.add(jugadoresRestantes);

        categoriasDisponibles.setVisible(false);
        categoriasDisponibles.setBounds(10, 130, 600, 30);
        categoriasDisponibles.setFont(fuente);
        categoriasDisponibles.setText("Categorias disponibles: Futbol, Basket, Matematica");
        ventana.add(categoriasDisponibles);

        categoriaLabel.setVisible(false);
        categoriaLabel.setBounds(10, 170, 200, 30);
        categoriaLabel.setFont(fuente);
        categoriaLabel.setText("Elección de categoria: ");
        ventana.add(categoriaLabel);

        categoria.setVisible(false);
        categoria.setBounds(190, 170, 100, 30);
        categoria.setFont(fuenteSecundaria);
        setPlaceholder(categoria, "Categoria");
        ventana.add(categoria);

        jugar.setVisible(false);
        jugar.setBounds(300, 170, 100, 30);
        ventana.add(jugar);

        //Acciones------------------------------------------------------------------------------------------------------
        confirmar.addActionListener(e -> {
            String input = cantidadJugadores.getText();

            if (input.equals("Cantidad de jugadores") || input.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de jugadores");
            } else {
                try {
                    cantidad = Integer.parseInt(input);

                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a 0");
                    } else {
                        System.out.println("Cantidad de jugadores: " + cantidad);

                        cantidadJugadores.setFocusable(false);
                        setPlaceholder(cantidadJugadores, "Cantidad de jugadores");
                        confirmar.setEnabled(false);

                        nombreJugadorLabel.setVisible(true);
                        nombreJugador.setVisible(true);
                        registrar.setVisible(true);
                        jugadoresRestantes.setVisible(true);
                        jugadoresRestantes.setText("Jugadores restantes: " + cantidad);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
                }
            }
        });

        registrar.addActionListener(e -> {
            String input = nombreJugador.getText();

            if (cantidad != 0) {

                if (input.equals("Nombre del jugador") || input.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del jugador");
                } else {
                    System.out.println("Nombre del jugador: " + input);
                    //CREAR OBJETO AQUI Y AGREGARLO A LA LISTA DE JUGADORES
                    setPlaceholder(nombreJugador, "Nombre del jugador");
                    --cantidad;
                    jugadoresRestantes.setText("Jugadores restantes: " + cantidad);

                    if (cantidad == 0) {
                        nombreJugadorLabel.setFocusable(false);
                        nombreJugador.setFocusable(false);
                        registrar.setEnabled(false);

                        categoriasDisponibles.setVisible(true);
                        categoriaLabel.setVisible(true);
                        categoria.setVisible(true);
                        jugar.setVisible(true);
                    }
                }
            }
        });

        jugar.addActionListener(e -> {
            String input = categoria.getText();

            if (input.equals("Categoria") || input.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la categoria");
            } else {
                System.out.println("Categoria: " + input);
                //CREAR OBJETO AQUI Y AGREGARLO A LA LISTA DE JUGADORES
                setPlaceholder(categoria, "Categoria");
                ventana.dispose();
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
