package com.denniseckerskorn.ejercicios.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Library which includes general methods for INPUT/OUTPUT.
public class LibIO {
    private static Scanner lector = new Scanner(System.in);

    // **** METHODS TO READ USER INPUT WITH SCANNER FOR DIFFERENT DATA TYPES, NO VALIDATION: ****

    /**
     * Method which receives a String as message and validates if the user input is equal to "true" or "false"
     *
     * @param message String
     * @return boolean true or false.
     */
    public static boolean validateBoolean(String message) {
        boolean valid;
        String result;
        do {
            System.out.println(message);
            result = lector.nextLine().trim().toLowerCase();
            valid = result.equals("true") || result.equals("false");
            if (!valid) {
                System.out.println("Error, only true or false");
            }
        } while (!valid);
        return Boolean.parseBoolean(result);

    }

    /**
     * Method to request a Byte showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return byte introduced by user.
     */
    public static byte requestByte(String message) {
        System.out.println(message);
        return Byte.parseByte(lector.nextLine());
    }

    /**
     * Method to request an Integer showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return int introduced by user.
     */
    public static int requestInt(String message) {
        System.out.println(message);
        return Integer.parseInt(lector.nextLine());
    }

    /**
     * Method to request a Long showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return long introduced by user.
     */
    public static long requestLong(String message) {
        System.out.println(message);
        return Long.parseLong(lector.nextLine());
    }

    /**
     * Method to request a Float showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return float introduced by user.
     */
    public static float requestFloat(String message) {
        System.out.println(message);
        return Float.parseFloat(lector.nextLine());
    }

    /**
     * Method to request a Double showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return double introduced by user.
     */
    public static double requestDouble(String message) {
        System.out.println(message);
        return Double.parseDouble(lector.nextLine());
    }

    /**
     * Method to request a Char showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return char introduced by user.
     */
    public static char requestChar(String message) {
        System.out.println(message);
        return lector.nextLine().charAt(0);
    }

    /**
     * Method to request a String showing a message as parameter, NO validation included.
     *
     * @param message for user (String).
     * @return String introduced by user.
     */
    public static String requestString(String message) {
        System.out.println(message);
        return lector.nextLine();
    }


    // **** METHODS TO READ USER INPUT SHOWING A MESSAGE FOR THE USER, THESE METHODS INCLUDE VALIDATION. ****


    /**
     * Method to request a Byte showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (byte).
     * @param max     value (byte).
     * @return byte introduced by user and validated.
     */
    public static byte requestByte(String message, byte min, byte max) {
        boolean valid;
        byte result;
        do {
            System.out.println(message);
            result = Byte.parseByte(lector.nextLine());
            valid = (result >= min && result <= max);
            if (!valid) {
                System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request an Integer showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (int).
     * @param max     value (int).
     * @return int introduced by user and validated.
     */
    public static int requestInt(String message, int min, int max) {
        boolean valid;
        int result;
        do {
            System.out.println(message);
            result = Integer.parseInt(lector.nextLine());
            valid = (result >= min && result <= max);
            if (!valid) {
                System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
            }
        } while (!valid);
        return result;
    }

    public static int requestIntValidating(String message, int min, int max) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.println(message);
            if (lector.hasNextInt()) {
                result = lector.nextInt();
                if (result >= min && result <= max) {
                    valid = true;
                } else {
                    System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
                }
            } else {
                System.out.println("Please introduce a valid number.");
                lector.next(); // Limpiar el buffer de entrada
            }
        } while (!valid);
        lector.nextLine();
        return result;
    }

    /**
     * Method to request a Long showing a message for the user, validation between min value and max value.
     *
     * @param message for user (String).
     * @param min     value (long).
     * @param max     value (long).
     * @return long introduced by user and validated.
     */
    public static long requestLong(String message, long min, long max) {
        boolean valid;
        long result;
        do {
            System.out.println(message);
            result = Long.parseLong(lector.nextLine());
            valid = (result >= min && result <= max);
            if (!valid) {
                System.out.printf("Error => Minimum Value: %d, Maximum Value: %d\n", min, max);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a Float showing a message for the user, validation between min value and max value.
     *
     * @param message for user
     * @param min     value (float)
     * @param max     value (float)
     * @return float introduced by user and validated.
     */
    public static float requestFloat(String message, float min, float max) {
        boolean valid;
        float result;
        do {
            System.out.println(message);
            result = Float.parseFloat(lector.nextLine());
            valid = (result >= min && result <= max);
            if (!valid) {
                System.out.printf("Error => Minimum Value: %.2f, Maximum Value: %.2f\n", min, max);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a Double showing a message for the user, validation between min and max value.
     *
     * @param message for user (String)
     * @param min     value (double)
     * @param max     value (double)
     * @return double introduced by user and validated.
     */
    public static double requestDouble(String message, double min, double max) {
        boolean valid;
        double result;
        do {
            System.out.println(message);
            result = Double.parseDouble(lector.nextLine());
            valid = (result >= min && result <= max);
            if (!valid) {
                System.out.printf("Error => Minimum Value: %.2f, Maximum Value: %.2f\n", min, max);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request a certain Character, Message and Character to request is passed as parameter.
     * After reading the character it will be changed to lower case.
     * If not valid, it will keep asking for the character.
     *
     * @param message for user (String).
     * @param c       Character to validate.
     * @return validated character which was introduced by user.
     */
    public static char requestChar(String message, char c) {
        char result;
        boolean valid;
        do {
            System.out.println(message);
            result = lector.nextLine().toLowerCase().charAt(0);
            valid = result == Character.toLowerCase(c);
            if (!valid) {
                System.out.printf("The character should be %c\n", c);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to request two Characters, Message and Characters to request is passed as parameter.
     * After reading the characters they will be changed to lower case.
     * If not valid, it will keep asking for the character.
     *
     * @param message for user (String).
     * @param c1      Character to validate (char).
     * @param c2      Character to validate (char).
     * @return validated character which was introduced by user.
     */
    public static char requestChar(String message, char c1, char c2) {
        char result;
        boolean valid;
        do {
            System.out.println(message);
            result = lector.nextLine().toLowerCase().charAt(0);
            valid = (c1 + "" + c2).toLowerCase().indexOf(result) != -1;
            if (!valid) {
                System.out.printf("Error => El carácter debe ser %c o %c\n", c1, c2);
            }
        } while (!valid);
        return result;
    }

    /**
     * Method to read a given String by the user, validating the allowed length for the String.
     *
     * @param message for the user (String).
     * @param min     value length for String (int).
     * @param max     value lenght for String (int).
     * @return String introduced by the user.
     */
    public static String requestString(String message, int min, int max) {
        boolean valid;
        String result;
        do {
            System.out.println(message);
            result = lector.nextLine();
            valid = result.length() >= min && result.length() <= max;
            if (!valid) {
                System.out.printf("Error => Minimum length: %d, Maximum length: %d\n", min, max);
            }
        } while (!valid);
        return result;
    }

    /**
     * Método que recibe un mensaje y el formato a seguir para la fecha, una vez tenga los parámetros se validan.
     *
     * @param mensaje
     * @param format
     * @return
     */
    public static Date solicitarFechaDate(String mensaje, SimpleDateFormat format) { //Añadir fecha minima y fecha maxima o periodo...
        boolean valido;
        Date fecha = null;
        do {
            System.out.println(mensaje);
            String fechaStr = lector.nextLine();
            try { //obligatorio, si no, no nos deja seguir...
                fecha = format.parse(fechaStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            valido = fecha != null;
            if (!valido) {
                System.out.println("El formato de la fecha no es válido");
            }
        } while (!valido);
        return fecha;
    }
}
