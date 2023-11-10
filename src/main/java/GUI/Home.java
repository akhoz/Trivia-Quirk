package GUI;
import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    public Home () {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelBotones = new JPanel(new FlowLayout());
        JLabel titulo = new JLabel("Trivia Quirk");
        Font fuente = new Font("Arial", Font.BOLD, 30);

        Dimension dim = new Dimension(250, 50);
        JButton singlePlayer = new JButton("Jugar");
        JButton exit = new JButton("Salir");
        singlePlayer.setPreferredSize(dim);
        exit.setPreferredSize(dim);

        panelBotones.add(singlePlayer, BorderLayout.CENTER);

        singlePlayer.addActionListener(e -> {
           // new Jugar();
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
    }

}