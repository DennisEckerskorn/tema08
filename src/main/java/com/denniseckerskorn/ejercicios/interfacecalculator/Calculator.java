package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;

public class Calculator {
    public enum Estado {
        OPERANDO_ENTERO, PUNTO, OPERANDO_DECIMAL, OPERADOR, ERROR
    }

    private Estado estadoActual;
    private Estado[][] diagramaEstados;

    public Calculator() {
        estadoActual = Estado.OPERANDO_ENTERO;
        diagramaEstados = new Estado[][]{
                {Estado.OPERANDO_ENTERO, Estado.PUNTO, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.ERROR},
                {Estado.OPERANDO_DECIMAL, Estado.OPERADOR, Estado.ERROR},
                {Estado.OPERANDO_ENTERO, Estado.ERROR},
                {Estado.ERROR}
        };
    }

    //esTransicionValida(Estado)   Estado.OPERANDO_ENTERO.ordinal()
}
