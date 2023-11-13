package Backend.Partida;

import poo.proyecto2.triviaquirk.iJugador;
import poo.proyecto2.triviaquirk.iSuscriptorPreguntas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Marcador extends JFrame implements iSuscriptorPreguntas {
    private JTextArea textArea;

    public Marcador() {
        this.setTitle("Marcador del juego");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(3);
        this.textArea = new JTextArea(15, 20);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        this.setContentPane(panel);
    }

    public void publicarPuntaje(ArrayList<iJugador> listaJugadores) {
        this.textArea.setText("");
        this.textArea.setText("Actualizando marcador...\n");

        try {
            Thread.sleep(500L);
        } catch (InterruptedException var5) {
            Logger.getLogger(Marcador.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        this.textArea.setText("");
        String stringMarcador = "Marcador Actual:\n";

        iJugador jugador;
        for(Iterator var3 = listaJugadores.iterator(); var3.hasNext(); stringMarcador = stringMarcador + String.format("%s:\t\t%d\n", jugador.obtenerNombreJugador(), jugador.obtenerPuntaje())) {
            jugador = (iJugador)var3.next();
        }

        this.textArea.setText(stringMarcador);
    }
}
