package com.denniseckerskorn.ejercicios.tema08;

import javax.swing.*;
import java.awt.*;

public class Ejercicio03 {
    public Ejercicio03() {
        JFrame frame = new JFrame("Hola Swing");
        int x = 800;
        int y = 600;
        frame.setSize(x, y);
        Container container = frame.getContentPane();
        container.setLayout(null);

        JLabel label = new JLabel("Bienvenido al mundo de las interfaces graficas");

        label.setBounds(20, 20, 300, 50);
        container.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
