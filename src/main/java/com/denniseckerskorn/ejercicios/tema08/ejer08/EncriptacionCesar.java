package com.denniseckerskorn.ejercicios.tema08.ejer08;

import javax.print.attribute.standard.Finishings;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class EncriptacionCesar {
    private final int semilla;
    private final String mensaje;
    private final int claveCifrado;

    public EncriptacionCesar(int claveCifrado) {
        this.semilla = 123456; //Semilla, al ser igual se genera la misma secuencia de numeros aleatorios.
        mensaje = ""; //Mensaje a encriptar.
        this.claveCifrado = claveCifrado; //Valor de desplazamiento del cifrado.
    }

    /**
     * Método que encripta un mensaje usando la encriptación Cesar.
     * Se crea un StringBuilder para añadir el mensaje encriptado.
     * Se crea un objeto Random con la semilla del constructor.
     * Se recorre el mensaje y se almacena en cada iteración el carácter correspondiente.
     * Si el carácter es una letra, se comprueba si es minúscula o mayúscula.
     * En el caso de que sea minúscula, se establece el valor de 'inicio' en 'a',
     * y en el caso de que sea mayúscula, se establece en 'A'.
     * Se genera un valor aleatorio entre 0 y la longitud del mensaje utilizando la semilla.
     * Este valor aleatorio se suma a la clave de cifrado para introducir variabilidad en el cifrado.
     * Se aplica el cifrado Cesar al carácter utilizando la fórmula:
     * ((caracter - inicio + claveConSemilla) % 26 + inicio).
     * Finalmente, el carácter cifrado se añade al StringBuilder.
     *
     * @return Mensaje cifrado con las carácterísticas mencionadas anteriormente.
     */
    public String encriptar(String mensaje) {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random(semilla);

        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            if (Character.isLetter(c)) {
                char inicio;
                if (Character.isLowerCase(c)) {
                    inicio = 'a';
                } else {
                    inicio = 'A';
                }
                int claveConSemilla = claveCifrado + rnd.nextInt(mensaje.length());
                c = (char) ((c - inicio + claveConSemilla) % 26 + inicio);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Método que desencripta un mensaje encriptado usando la encriptación César.
     * Se crea un StringBuilder para almacenar el mensaje desencriptado.
     * Se crea un objeto Random con la semilla del constructor.
     * Se recorre el mensaje encriptado y se almacena en cada iteración el carácter correspondiente.
     * Si el carácter es una letra, se comprueba si es minúscula o mayúscula.
     * En el caso de que sea minúscula, se establece el valor de 'inicio' en 'a',
     * y en el caso de que sea mayúscula, se establece en 'A'.
     * Se genera un valor aleatorio entre 0 y la longitud del mensaje utilizando la semilla.
     * Este valor aleatorio se suma a la clave de cifrado para introducir variabilidad en el descifrado.
     * Se aplica el descifrado César al carácter utilizando la fórmula:
     * ((caracter - inicio - claveSemilla + 26) % 26 + inicio).
     * Finalmente, el carácter descifrado se añade al StringBuilder.
     *
     * @param mensajeEncriptado El mensaje encriptado que se desea desencriptar.
     * @return El mensaje desencriptado.
     */
    public String desencriptar(String mensajeEncriptado) {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random(semilla);

        for (int i = 0; i < mensajeEncriptado.length(); i++) {
            char c = mensajeEncriptado.charAt(i);
            if (Character.isLetter(c)) {
                char inicio;
                if (Character.isLowerCase(c)) {
                    inicio = 'a';
                } else {
                    inicio = 'A';
                }
                int claveSemilla = claveCifrado + rnd.nextInt(mensajeEncriptado.length());
                c = (char) ((c - inicio - claveSemilla + 26) % 26 + inicio);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public int getSemilla() {
        return semilla;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getClaveCifrado() {
        return claveCifrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EncriptacionCesar that = (EncriptacionCesar) o;

        if (semilla != that.semilla) return false;
        if (claveCifrado != that.claveCifrado) return false;
        return Objects.equals(mensaje, that.mensaje);
    }

    @Override
    public int hashCode() {
        int result = semilla;
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        result = 31 * result + claveCifrado;
        return result;
    }

    @Override
    public String toString() {
        return "EncriptacionCesar{" +
                "semilla=" + semilla +
                ", mensaje='" + mensaje + '\'' +
                ", claveCifrado=" + claveCifrado +
                '}';
    }
}
