package com.denniseckerskorn.ejercicios.tema08;

import javax.swing.*;
import java.awt.*;

public class Ejercicio04 {
    public Ejercicio04() {
        int x = 1024;
        int y = 768;
        JFrame frame = new JFrame();
        frame.setSize(x, y);

        Container container = frame.getContentPane();
        container.setLayout(null);

        JLabel label1 = new JLabel("Jiu Jitsu");
        JLabel label2 = new JLabel("Video Juegos");
        JLabel label3 = new JLabel("Programar");
        JLabel label4 = new JLabel("Senderismo");
        JLabel label5 = new JLabel("Ciclismo");

        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setFont(new Font("Courier", Font.ITALIC, 12));
        label3.setFont(new Font("sans-serif", Font.PLAIN, 15));
        label4.setFont(new Font("Comic Sans", Font.BOLD, 17));
        label5.setFont(new Font("Tahoma", Font.ITALIC, 5));

        label1.setBounds(20, 20, 200, 100);
        label2.setBounds(50, 50, 200, 100);
        label3.setBounds(70, 70, 200, 100);
        label4.setBounds(90, 90, 200, 100);
        label5.setBounds(110, 110, 200, 100);

        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(label4);
        container.add(label5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
