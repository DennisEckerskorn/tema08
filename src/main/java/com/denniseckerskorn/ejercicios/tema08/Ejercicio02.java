package com.denniseckerskorn.ejercicios.tema08;

import javax.swing.*;

public class Ejercicio02 {
    public Ejercicio02(){
        JFrame ventana = new JFrame("Hola Swing");
        ventana.setSize(800,600);
        JPanel panel = new JPanel();
        ventana.setContentPane(panel);


        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
}
