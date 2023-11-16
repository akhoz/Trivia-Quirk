package Frontend;

import Backend.Partida.*;
import Backend.Partida.Categoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;


/**
 * La clase Registro, encargada de registrar a los jugadores y decidir cuantas categorias jugaran
 */
public class Registro extends JFrame {

    private int cantidad;
    private int numeroDePartida;
    private int cantidadDeCategoriasaJugar;
    private ArrayList<String> jugadoresRegistrados = new ArrayList<>();
    private Partida partida;
    private Jugador jugadores;
    private Categoria categoria = Categoria.getInstance();

    public Registro() {
        //Ventana------------------------------------------------------------------------------------------------------
        JFrame ventana = new JFrame("Registrando jugadores");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Fuentes-------------------------------------------------------------------------------------------------------
        Font fuente = new Font("Arial", Font.BOLD, 15);
        Font fuenteSecundaria = new Font("Arial", Font.PLAIN, 8);

        //Declaracion---------------------------------------------------------------------------------------------------
        JLabel cantidadJugadoresLabel = new JLabel();
        JLabel nombreJugadorLabel = new JLabel();
        JLabel jugadoresRestantes = new JLabel();
        JLabel cantidadCategoriasLabel = new JLabel();
        JLabel categoriasDisponibles = new JLabel();
        JLabel categoriaLabel = new JLabel();
        JLabel categoriasRestantes = new JLabel();

        JTextField cantidadJugadores = new JTextField();
        JTextField nombreJugador = new JTextField();
        JTextField cantidadCategorias = new JTextField();
        JTextField categoriaTextField = new JTextField();

        JButton confirmar = new JButton("Confirmar");
        JButton registrar = new JButton("Registrar");
        JButton confirmarCategorias = new JButton("Confirmar");
        JButton agregar = new JButton("Agregar");
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

        regresar.setBounds(5, 327, 100, 30);
        jugar.setVisible(false);
        jugar.setBounds(120, 327, 100, 30);
        ventana.add(jugar);
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
        categoriasDisponibles.setText("Categorias disponibles: Futbol, Basket, Matematica, Videojuegos");
        ventana.add(categoriasDisponibles);

        cantidadCategoriasLabel.setVisible(false);
        cantidadCategoriasLabel.setBounds(10, 170, 200, 30);
        cantidadCategoriasLabel.setFont(fuente);
        cantidadCategoriasLabel.setText("Cantidad de categorías: ");
        ventana.add(cantidadCategoriasLabel);

        cantidadCategorias.setVisible(false);
        cantidadCategorias.setBounds(190, 170, 100, 30);
        cantidadCategorias.setFont(fuenteSecundaria);
        setPlaceholder(cantidadCategorias, "Cantidad de categorías");
        ventana.add(cantidadCategorias);

        confirmarCategorias.setVisible(false);
        confirmarCategorias.setBounds(300, 170, 100, 30);
        ventana.add(confirmarCategorias);

        categoriaLabel.setVisible(false);
        categoriaLabel.setBounds(10, 210, 200, 30);
        categoriaLabel.setFont(fuente);
        categoriaLabel.setText("Elección de categoria: ");
        ventana.add(categoriaLabel);

        categoriaTextField.setVisible(false);
        categoriaTextField.setBounds(190, 210, 100, 30);
        categoriaTextField.setFont(fuenteSecundaria);
        setPlaceholder(categoriaTextField , "Categoria");
        ventana.add(categoriaTextField );

        agregar.setVisible(false);
        agregar.setBounds(300, 210, 100, 30);
        ventana.add(agregar);

        categoriasRestantes.setVisible(false);
        categoriasRestantes.setBounds(10, 250, 600, 30);
        categoriasRestantes.setFont(fuente);
        ventana.add(categoriasRestantes);
        //Acciones------------------------------------------------------------------------------------------------------
        /**
         * Acción realizada al hacer clic en el botón "Confirmar" para la cantidad de jugadores.
         *
         * @param e Evento de acción.
         */
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

        /**
         * Acción realizada al hacer clic en el botón "Registrar" para el registro de jugadores.
         *
         * @param e Evento de acción.
         */
        registrar.addActionListener(e -> {
            String input = nombreJugador.getText();

            if (cantidad != 0) {

                if (input.equals("Nombre del jugador") || input.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del jugador");
                } else {
                    System.out.println("Nombre del jugador: " + input);
                    jugadoresRegistrados.add(input);

                    setPlaceholder(nombreJugador, "Nombre del jugador");
                    --cantidad;
                    jugadoresRestantes.setText("Jugadores restantes: " + cantidad);

                    if (cantidad == 0) {
                        nombreJugadorLabel.setFocusable(false);
                        nombreJugador.setFocusable(false);
                        registrar.setEnabled(false);

                        categoriasDisponibles.setVisible(true);
                        cantidadCategoriasLabel.setVisible(true);
                        cantidadCategorias.setVisible(true);
                        confirmarCategorias.setVisible(true);

                        numeroDePartida = categoria.registrarPartida();
                        System.out.println("Numero de partida: " + numeroDePartida);
                        partida = new Partida(numeroDePartida);

                        for (String jugador : jugadoresRegistrados) {
                            jugadores = new Jugador(jugador);
                            partida.agregarJugador(jugadores);
                        }

                        System.out.println("Jugadores registrados para la partida " + numeroDePartida + ": " + partida.getNombreJugadores());

                    }
                }
            }
        });

        /**
         * Acción realizada al hacer clic en el botón "Confirmar Categorías" para la cantidad de categorías.
         *
         * @param e Evento de acción.
         */
        confirmarCategorias.addActionListener(e -> {
            String input = cantidadCategorias.getText();

            try {
                cantidadDeCategoriasaJugar = Integer.parseInt(input);
                System.out.println("Cantidad de categorías: " + cantidadDeCategoriasaJugar);

                if (cantidadDeCategoriasaJugar > 0) {
                    categoriaLabel.setVisible(true);
                    categoriaTextField.setVisible(true);
                    agregar.setVisible(true);
                    categoriasRestantes.setVisible(true);
                    categoriasRestantes.setText("Categorias restantes: " + cantidadDeCategoriasaJugar);
                    confirmarCategorias.setEnabled(false);
                    cantidadCategorias.setFocusable(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número mayor a 0");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
            }
        });

        /**
         * Acción realizada al hacer clic en el botón "Agregar" para la adición de categorías.
         *
         * @param e Evento de acción.
         */
        agregar.addActionListener(e -> {

            if (cantidadDeCategoriasaJugar > 0) {

                String input = categoriaTextField.getText().toLowerCase();

                if (input.equals("categoria") || input.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese la categoría");
                } else if (!input.equals("futbol") && !input.equals("basket") && !input.equals("matematica") && !input.equals("videojuegos")) {
                    JOptionPane.showMessageDialog(null, "Ingrese una categoría válida");
                } else {
                    setPlaceholder(categoriaTextField, "Categoria");
                    System.out.println("Categoria seleccionada: " +  input);
                    categoria.appendCategoria(input);
                    --cantidadDeCategoriasaJugar;
                    categoriasRestantes.setText("Categorias restantes: " + cantidadDeCategoriasaJugar);

                    if (cantidadDeCategoriasaJugar == 0) {
                        agregar.setEnabled(false);
                        categoriaTextField.setFocusable(false);
                        jugar.setVisible(true);
                    }
                }
            }
        });

        /**
         * Acción realizada al hacer clic en el botón "Jugar" para iniciar la partida.
         *
         * @param e Evento de acción.
         */
        jugar.addActionListener(e -> {
            categoria.setCategoria(categoria.getCategorias().get(0));
            new Trivia(categoria, partida);
            System.out.println(categoria.getCategorias().size());
            ventana.dispose();
        });

        /**
         * Acción realizada al hacer clic en el botón "Regresar" para volver a la ventana principal.
         *
         * @param e Evento de acción.
         */
        regresar.addActionListener(e -> {
            System.out.println("Regresando a la ventana principal");
            ventana.dispose();
            MenuPrincipal.getInstance();
        });


        //Ventana------------------------------------------------------------------------------------------------------
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }


    /**
     * Método para establecer un placeholder en un campo de texto.
     *
     * @param textField  Campo de texto al que se le aplicará el placeholder.
     * @param placeholder Texto del placeholder.
     */
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
