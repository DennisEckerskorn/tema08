package com.denniseckerskorn.ejercicios.tema08.ejer06;

import javax.swing.*;
import java.awt.*;

public class Ejercicio06 {
    public Ejercicio06() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 1024;
        int height = 768;

        //Se posiciona la ventana en medio de la pantalla:
        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round(height / 2f);

        //Se crea la ventana principal:
        JFrame frame = new JFrame("IMC");
        frame.setSize(x,y);
        frame.setBounds(x,y,width,height);

        //Contenedor dentro del frame:
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //JLabel para indicar el peso:
        JLabel title = new JLabel("Calculadora IMC");
        panel.add(title);

        JOptionPane.showInputDialog("Ingresa tu peso en KG:");






        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
