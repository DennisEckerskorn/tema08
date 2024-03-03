package com.denniseckerskorn.ejercicios.interfacecalculator;

public class Boton {
    public enum Accion {
        DIGITO, PUNTO, OPERADOR, IGUAL, ON, OFF, AC
    }

    private final String texto;
    private final Accion accion;

    public Boton(String texto, Accion accion) {
        this.texto = texto;
        this.accion = accion;
    }

    public Accion getAccion() {
        return accion;
    }

    public String getTexto() {
        return texto;
    }
}
