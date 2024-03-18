package com.denniseckerskorn.ejercicios.tema08.ejer06;

public enum Clasificacion {
    DELGADEZ_SEVERA("Delgadez Severa"),
    DELGADEZ_MODERADA("Delgadez Moderada"),
    DELGADEZ_LEVE("Delgadez Leve"),
    NORMAL("Normal"),
    PREOBESIDAD("Preobesidad"),
    OBESIDAD_LEVE("Obesidad Leve"),
    OBESIDAD_MEDIA("Obesidad Media"),
    OBESIDAD_MORBIDA("Obesidad Morbida");

    private String message;

    Clasificacion(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}