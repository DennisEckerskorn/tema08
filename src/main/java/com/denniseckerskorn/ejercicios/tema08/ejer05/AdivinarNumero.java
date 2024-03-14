package com.denniseckerskorn.ejercicios.tema08.ejer05;

import java.util.Random;
import java.util.Scanner;

public class AdivinarNumero {
    Scanner lector = new Scanner(System.in);
    Random rnd = new Random();
    public enum ESTADO_JUGADA{NUMERO_MAYOR, NUMERO_MENOR, IGUAL}
    public AdivinarNumero() {




    }

    public int generarNumAleatorio(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public void jugada(int min, int max, int numJugada, int numAleatorio) {
        //FALTA EL CONTADOR
        for(int i = max; i >= min; i--) {
            if(numJugada > numAleatorio) {
            //Enum con mensaje: NUMERO ES MENOR
            } else if(numJugada < numAleatorio) {
                //Enum con mensaje: NUMERO ES MAYOR
            } else {
                //Enum con mensaje: GANADO (Numero es igual)
            }
        }
    }
}
