package com.denniseckerskorn.ejercicios.tema08.ejer07;

import javax.swing.*;
import java.awt.*;

public class GUIJuego {
    public GUIJuego() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 1024;
        int height = 764;

        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round((height / 2f));

        JFrame frame = new JFrame("Piedra - Papel - Tijeras");
        frame.setBounds(x,y,width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Matriz con GridLayout para el juego:
        /*
        *   Label   Image   Image   Label
        *   Label   Image   Image   Label
        *   Label   Image   Image   Label
        *               Boton
        *   Puntuacion      Player  CPU
        *                   Label   Label
        * */

        JPanel borderPanel = new JPanel(new BorderLayout());

        Checkbox checkboxPiedra = new Checkbox("Piedra");
        borderPanel.add(checkboxPiedra, BorderLayout.WEST);

        Checkbox checkboxPapel = new Checkbox("Papel");
        borderPanel.add(checkboxPapel, BorderLayout.CENTER);

        Checkbox checkboxTijera = new Checkbox("Tijeras");
        borderPanel.add(checkboxTijera, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Jugar");
        buttonPanel.add(button);

        //JLabel emptyLabel = new JLabel();
        //panel.add(emptyLabel);

        JLabel scoreLabel = new JLabel("Puntuacion");
        JLabel playerScore = new JLabel("Puntuacion Jugador");
        JLabel cpuScore = new JLabel("Puntuación CPU");

        //panel.add(scoreLabel);
        //panel.add(playerScore);
        //panel.add(cpuScore);

        frame.add(borderPanel);
        //borderPanel.add(panelCheckBox, BorderLayout.CENTER);
        borderPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
