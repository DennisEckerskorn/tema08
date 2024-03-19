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

        JPanel panel = new JPanel(new GridLayout(6,4,5,5));




        frame.add(panel);
        frame.setVisible(true);
    }
}
