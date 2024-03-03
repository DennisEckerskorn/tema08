package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private final Calculator calculator;
    private final ActionListener actionDigito;
    private final ActionListener actionOperador;

    public CalculatorController() {
        calculator = new Calculator();
        actionDigito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
                calculator.addDigito(boton.getText());
            }
        };

        actionOperador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = getBoton(e);
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
}
