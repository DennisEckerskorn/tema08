package com.denniseckerskorn.ejercicios.tema08.ejer05;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Ejercicio05 {
    public Ejercicio05() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = 1024;
        int height = 768;
        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round(height / 2f);


        //Ventana:
        JFrame frame = new JFrame("Juego Adivinar Numero");
        frame.setSize(width, height);
        frame.setBounds(x, y, width, height);


        //Contenedor dentro de la ventana:
        Container container = frame.getContentPane();
        container.setLayout(null);


        JLabel title = new JLabel("++++++ ADIVINAR EL NÚMERO ++++++");
        title.setBounds(320, 20, 400, 50);
        title.setFont(new Font("Courier", Font.BOLD, 20));
        container.add(title);


        //JLabel para el número de intentos:
        JLabel labelNumIntentos = new JLabel("Te quedan " + " intentos: "); //FALTA AÑADIR EL CONTADOR
        labelNumIntentos.setBounds(360, 410, 200, 50);
        //Estilo de texto del JLabel
        labelNumIntentos.setFont(new Font("Courier", Font.BOLD, 15));
        //Se añade el JLabel al container de la ventana.
        container.add(labelNumIntentos);


        //JTextField para el ingreso del número a adivinar:
        JTextField fieldUserInput = new JTextField();
        fieldUserInput.setBounds(384, 465, 200, 50);
        container.add(fieldUserInput);


        //Botón para jugar:
        JButton buttonPlay = new JButton("JUGAR");
        buttonPlay.setBounds(384, 512, 200, 50);
        container.add(buttonPlay);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
