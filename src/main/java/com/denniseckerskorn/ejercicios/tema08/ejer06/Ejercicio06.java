package com.denniseckerskorn.ejercicios.tema08.ejer06;

import javax.swing.*;
import javax.swing.border.Border;
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
        JFrame frame = new JFrame("Calculadora IMC");
        frame.setSize(x, y);
        frame.setBounds(x, y, width, height);

        //Contenedor dentro del frame:
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5)); //3 filas, 2 columnas, espaciado

        //Matriz para posicionar los elementos:
        String[][] elements = {
                {"Ingresa tu peso en KG:", ""},
                {"Ingresa tu altura en CM:", ""}
        };

        for (int i = 0; i < elements.length; i++) {
            JLabel label = new JLabel(elements[i][0]);
            JTextField textField = new JTextField();
            panel.add(label);
            panel.add(textField);
        }


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
