package Frontend;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private static MenuPrincipal instancia; //Singleton

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

        setTitle("Trivia Quirk");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static MenuPrincipal getInstance() { //Implementacion del patron Singleton
        if (instancia == null) {
            instancia = new MenuPrincipal();
        }
        return instancia;
    }

}