package com.denniseckerskorn.ejercicios.tema08.ejer06;

import com.denniseckerskorn.ejercicios.lib.LibIO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio06 {
    private Clasificacion clasificacion;

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
        frame.setBounds(x, y, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Contenedor dentro del frame:
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        //Se ha probado redimensionar el textField sin exito...
        Dimension textFieldDimension = new Dimension(150, 30);

        JLabel labelKG = new JLabel("Introduce tu peso actual en Kilogramos KG [Formato: 00.00]:");
        JTextField textFieldKG = new JTextField();
        textFieldKG.setPreferredSize(textFieldDimension);

        JLabel labelAltura = new JLabel("Introduce tu altura en Centímetros CM [Formato: 0,00]");
        JTextField textFieldAltura = new JTextField();
        textFieldAltura.setPreferredSize(textFieldDimension);

        inputPanel.add(labelKG);
        inputPanel.add(textFieldKG);
        inputPanel.add(labelAltura);
        inputPanel.add(textFieldAltura);

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Calcular IMC");
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesoText = textFieldKG.getText();
                String alturaText = textFieldAltura.getText();

                if (!isValidDecimal(pesoText) || !isValidDecimal(alturaText)) {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduce valores decimales validos.", "Error", JOptionPane.ERROR_MESSAGE);
                    textFieldKG.setText("");
                    textFieldAltura.setText("");
                    return;
                } else {
                    float peso = Float.parseFloat(pesoText);
                    float altura = Float.parseFloat(alturaText);

                    float imc = IMC.calcularIMC(peso, altura);
                    String clasificacionObtenida = IMC.clasificarIMC(imc);

                    JOptionPane.showMessageDialog(frame, "Tu IMC es: " + imc + " y estas clasificado en: " + clasificacionObtenida);

                    textFieldKG.setText("");
                    textFieldAltura.setText("");
                }
            }
        });

        textFieldKG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });

        textFieldAltura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private boolean isValidDecimal(String input) {
        boolean hasDot = false;
        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            } else if (c == '.') {
                if (!hasDot) {
                    hasDot = true;
                } else {
                    isValid = false;
                    break;
                }
            } else {
                isValid = false;
                break;
            }
        }
        return isValid && hasDot;
    }
}
