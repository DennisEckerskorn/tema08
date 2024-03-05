package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private final Calculator calculator;
    private final JLabel pantalla;
    private final ActionListener actionDigito;
    private final ActionListener actionOperador;
    private final ActionListener actionIgual;
    //private final ActionListener actionON;
    //private final ActionListener actionOFF;
    //private final ActionListener actionAC;

    public CalculatorController(JLabel pantalla) {
        calculator = new Calculator();
        this.pantalla = pantalla;
        actionDigito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculator.addDigito(boton.getText());
                pantalla.setText(calculator.getResultado());
            }
        };

        actionOperador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculator.addOperador(boton.getText());
                pantalla.setText(calculator.getResultado());
            }
        };

        actionIgual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculator.resolver();
                pantalla.setText(calculator.getResultado());
            }
        };
    }

    private JButton getBoton(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            return (JButton) e.getSource();
        }
        return null;
    }

    public ActionListener getActionDigito() {
        return actionDigito;
    }

    public ActionListener getActionOperador() {
        return actionOperador;
    }

    public ActionListener getActionIgual() {
        return actionIgual;
    }

}
