package com.denniseckerskorn.ejercicios.tema08.ejer06;

public class IMC {

    public static float calcularIMC(float kg, float cm) {
        float alturaMetros = cm /100;
        return kg / (alturaMetros * alturaMetros);
    }
}
