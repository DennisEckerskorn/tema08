package com.denniseckerskorn.ejercicios.tema08.ejer05;

import java.util.Random;
import java.util.Scanner;

public class AdivinarNumero {
    private Random rnd = new Random();
    private int intentosRestantes;
    private int min;
    private int max;
    private int numeroAleatorio;

    public AdivinarNumero(int intentosRestantes, int min, int max) {
        this.intentosRestantes = intentosRestantes;
        this.min = min;
        this.max = max;
        this.numeroAleatorio = generarNumAleatorio(min, max);

    }

    public int generarNumAleatorio(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public Mensaje jugada(int numJugada) {
        if (numJugada > numeroAleatorio) {
            return Mensaje.NUMERO_MAYOR;
        } else if (numJugada < numeroAleatorio) {
            return Mensaje.NUMERO_MENOR;
        } else {
            return Mensaje.GANADO;
        }
    }

    public void decrementarIntentos() {
        intentosRestantes--;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

}
