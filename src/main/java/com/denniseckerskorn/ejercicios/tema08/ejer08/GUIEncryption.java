package com.denniseckerskorn.ejercicios.tema08.ejer08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEncryption {
    private EncriptacionCesar encriptacionCesar;
    public GUIEncryption() {
        encriptacionCesar = new EncriptacionCesar(3);
        int widht = 800;
        int height = 600;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        int x = (int) (dimension.getWidth() / 2f) - Math.round(widht / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round(height / 2f);

        //Ventana centrada en medio:
        JFrame frame = new JFrame("Encryption");
        frame.setBounds(x,y,widht,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JLabel labelEncrypt = new JLabel("Encriptar mensaje:");
        labelEncrypt.setBounds(250, 20, 150,100);

        JLabel labelDecrypt = new JLabel("Desencriptar mensaje:");
        labelDecrypt.setBounds(250,160,150,100);

        JTextField textEncrypt = new JTextField();
        textEncrypt.setBounds(400,60,300,20);

        JTextField textDecrypt = new JTextField();
        textDecrypt.setBounds(400, 200, 300,20);

        JButton buttonEncrypt = new JButton("Encriptar");
        buttonEncrypt.setBounds(340,90,100,20);

        buttonEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensajeEncriptado = encriptacionCesar.encriptar(textEncrypt.getText());
                JOptionPane.showMessageDialog(null,mensajeEncriptado);
            }
        });

        JButton buttonDecrypt = new JButton("Desencriptar");
        buttonDecrypt.setBounds(340,230,100,20);

        buttonDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensajeDesencriptado = encriptacionCesar.desencriptar(textDecrypt.getText());
                JOptionPane.showMessageDialog(null,mensajeDesencriptado);
            }
        });

        panel.add(labelEncrypt);
        panel.add(labelDecrypt);
        panel.add(textEncrypt);
        panel.add(textDecrypt);
        panel.add(buttonEncrypt);
        panel.add(buttonDecrypt);

        frame.add(panel);
        frame.setVisible(true);
    }
}
