package Frontend;

import javax.swing.*;
import java.awt.*;

/**
 * La clase MenuPrincipal representa la ventana del menú principal de la aplicación Trivia Quirk.
 * Utiliza el patrón Singleton para garantizar una única instancia de la ventana.
 */
public class MenuPrincipal extends JFrame {

    private static MenuPrincipal instancia; // Singleton

    /**
     * Constructor privado para evitar instancias externas.
     */
    private MenuPrincipal() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelBotones = new JPanel(new FlowLayout());
        JLabel titulo = new JLabel("Trivia Quirk");
        Font fuente = new Font("Arial", Font.BOLD, 30);

        Dimension dim = new Dimension(250, 50);
        JButton jugar = new JButton("Jugar");
        JButton exit = new JButton("Salir");
        jugar.setPreferredSize(dim);
        exit.setPreferredSize(dim);

        panelBotones.add(jugar, BorderLayout.CENTER);

        jugar.addActionListener(e -> {
            new Registro();
            System.out.println("Jugar");
        });

        titulo.setFont(fuente);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);
        add(exit, BorderLayout.SOUTH);
        add(panel);

        exit.addActionListener(e -> {
            this.dispose();
        });

        setTitle("Trivia Quirk");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Obtiene la única instancia de la clase MenuPrincipal utilizando el patrón Singleton.
     *
     * @return La instancia única de MenuPrincipal.
     */
    public static MenuPrincipal getInstance() {
        if (instancia == null) {
            instancia = new MenuPrincipal();
        }
        return instancia;
    }

}
