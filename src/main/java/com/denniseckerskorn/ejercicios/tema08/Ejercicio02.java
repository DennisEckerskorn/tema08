package com.denniseckerskorn.ejercicios.tema08;

import javax.swing.*;
import java.awt.*;

public class Ejercicio02 {
    public Ejercicio02() {
        JFrame frame = new JFrame("Hola Swing");
        frame.setSize(800, 600);
        Container container = frame.getContentPane();

        JLabel label = new JLabel("Bienvenido al mundo de las interfaces gráficas");
        container.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
