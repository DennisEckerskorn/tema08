package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCalculator {
    StringBuilder sb = new StringBuilder();
    //Calculator calculator;
    public InterfaceCalculator(int width, int height) {
        Boton[][] textoBotones = {
                {new Boton("ON", Boton.Accion.ON),  new Boton("OFF", Boton.Accion.OFF), new Boton("%", Boton.Accion.OPERADOR), new Boton("/", Boton.Accion.OPERADOR)},
                {new Boton("7", Boton.Accion.DIGITO), new Boton("8", Boton.Accion.DIGITO), new Boton("9", Boton.Accion.DIGITO), new Boton("*", Boton.Accion.OPERADOR)},
                {new Boton("4", Boton.Accion.DIGITO), new Boton("5", Boton.Accion.DIGITO), new Boton("6", Boton.Accion.DIGITO), new Boton("-", Boton.Accion.OPERADOR)},
                {new Boton("1", Boton.Accion.DIGITO), new Boton("2", Boton.Accion.DIGITO), new Boton("3", Boton.Accion.DIGITO), new Boton("+", Boton.Accion.OPERADOR)},
                {new Boton("0", Boton.Accion.DIGITO), new Boton(".", Boton.Accion.PUNTO), new Boton("AC", Boton.Accion.AC), new Boton("=", Boton.Accion.IGUAL)},
        };

        CalculatorController calculatorController = new CalculatorController();

        JButton[] buttons = new JButton[textoBotones.length * textoBotones[0].length];
        JFrame ventana = new JFrame("Calculator");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2 - width / 2f);
        long y = Math.round(dimension.getHeight() / 2 - height / 2f);

        //Panel principal de la calculadora.
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        //Panel del display de la calculadora
        JPanel panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(1, 1, 5, 5));
        JLabel display = new JLabel("0", SwingConstants.RIGHT);
        display.setBackground(Color.CYAN);
        display.setOpaque(true);
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelDisplay.add(display);
        panelPrincipal.add(panelDisplay);

        //Panel de los botones de la calculadora
        JPanel panelBotones = new JPanel();
        GridLayout gridLayout = new GridLayout(textoBotones.length, textoBotones[0].length, 10, 10);
        panelBotones.setLayout(gridLayout);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Se ha pulsado el boton");
            }
        };

        int counter = 0;
        for(int i = 0; i < textoBotones.length; i++) {
            for(int j = 0; j < textoBotones[i].length; j++) {
                Boton boton = textoBotones[i][j];
                buttons[counter] = new JButton(boton.getTexto());
                switch(boton.getAccion()) {
                    case DIGITO:
                        buttons[counter].addActionListener(calculatorController.getActionDigito());
                        break;
                }
                panelBotones.add(buttons[counter]);
                counter++;
            }
        }
        panelPrincipal.add(panelBotones);

        ventana.setContentPane(panelPrincipal);
        ventana.setBounds((int)x, (int)y, width, height);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
