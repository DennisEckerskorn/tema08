package com.denniseckerskorn.ejercicios.tema08.ejer06;

public class IMC {
    private Clasificacion clasificacion;

    /**
     * Calculates the Body Mass Index (IMC) based on weight in kilograms and height in centimeters.
     *
     * @param kg Weight in kilograms.
     * @param cm Height in centimeters.
     * @return The calculated IMC.
     */
    public static float calcularIMC(float kg, float cm) {
        return kg / (cm * cm);
    }

    /**
     * Classifies the IMC into predefined categories.
     *
     * @param imc The Body Mass Index to be classified.
     * @return A message representing the classification.
     */
    public static String clasificarIMC(float imc) {
        if (imc < 16.00f) {
            return Clasificacion.DELGADEZ_SEVERA.getMessage();
        } else if (imc > 16.00f && imc < 16.99f) {
            return Clasificacion.DELGADEZ_MODERADA.getMessage();
        } else if (imc > 17.00f && imc < 18.49f) {
            return Clasificacion.DELGADEZ_LEVE.getMessage();
        } else if (imc > 18.5f && imc < 24.99) {
            return Clasificacion.NORMAL.getMessage();
        } else if (imc > 25.00f && imc < 29.99f) {
            return Clasificacion.PREOBESIDAD.getMessage();
        } else if (imc > 30.00f && imc < 34.99f) {
            return Clasificacion.OBESIDAD_LEVE.getMessage();
        } else if (imc > 35.00f && imc < 39.99f) {
            return Clasificacion.OBESIDAD_MEDIA.getMessage();
        } else if (imc >= 40.00f) {
            return Clasificacion.OBESIDAD_MORBIDA.getMessage();
        } else {
            return null;
        }
    }
}
