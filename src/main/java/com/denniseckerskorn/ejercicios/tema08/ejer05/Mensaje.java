package com.denniseckerskorn.ejercicios.tema08.ejer05;

public enum Mensaje {
    NUMERO_MAYOR("Tu numero es mayor"),
    NUMERO_MENOR("Tu numero es menor"),
    GANADO("¡Felicidades! Has adivinado el número"),
    INTENTO_INVALIDO("Ingresa un número válido"),
    NUMERO_INTENTOS("Te has quedado sin intentos");

    private String mensaje;

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}


