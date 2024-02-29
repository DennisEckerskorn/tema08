package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCalculator {
    StringBuilder sb = new StringBuilder();
    //Calculator calculator;
    public InterfaceCalculator() {
        JFrame calculator = new JFrame("Calculator");
        int width = 500;
        int height = 550;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        calculator.setSize(width, height);
        int x = (int) (dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int) (dimension.getHeight() / 2f) - Math.round(height / 2f);

        //Espacio para el display, (no se muestra aun???)
        JPanel displaySpace = new JPanel();
        displaySpace.setLayout(new GridLayout(width, 100));
        calculator.add(displaySpace);

        //Panel principal:
        JPanel mainPanel = new JPanel(new BoxLayout( 1, BoxLayout.Y_AXIS)); //Ajustar
        //Panel botones:
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));


        String[] buttonNames = { //COnvertir a matriz
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "%", "+"
        };
        for (String name : buttonNames) {
            JButton button = new JButton(name);
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.print(name);
                    handleButtonPress(button);
                }
            };
            button.addActionListener(actionListener);
            buttonPanel.add(button);
        }

        mainPanel.add(displaySpace);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        calculator.setContentPane(mainPanel);
        calculator.setBounds(x, y, width, height);
        calculator.setResizable(true);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }

    //Maneja el boton = pero peta al hacer una operacion...
    private void handleButtonPress(JButton button) {
        String buttonText = button.getText();
        if(buttonText.equals("=")) {
            double result = evaluateExpresion(sb.toString());
            sb.setLength(0);
            button.setText(Double.toString(result));
        } else {
            sb.append(buttonText);
            button.setText(sb.toString());
        }
    }

    //Coger la operacion a calcular
    private double evaluateExpresion(String expresion) {
        String[] parts = expresion.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double num2 = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return (num2 == 0) ? Double.POSITIVE_INFINITY : num1 / num2;
            case "%":
                return num1 % num2;
            default:
                return Double.POSITIVE_INFINITY;
        }
    }
}
