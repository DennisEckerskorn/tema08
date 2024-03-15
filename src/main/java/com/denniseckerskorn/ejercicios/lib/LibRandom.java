package com.denniseckerskorn.ejercicios.lib;
import java.util.Random;

//Library which includes different methods with Random.
public class LibRandom {
    private static Random rnd = new Random();


    // ********** METHODS TO GENERATE RANDOM NUMBERS **********


    /**
     * Method to generate a random number (int) between min and max, both values included.
     * Can be used in loops to generate many random numbers.
     * @param min value for random numbers (int).
     * @param max value for random numbers (int).
     * @return random number (int).
     */
    public static int randomInt(int min, int max){

        return rnd.nextInt(max - min + 1) + min;
    }

    /**
     * Method to generate a random number (double) between min and max, both values included.
     * Can be used in loops to generate many random numbers.
     * @param min value for random numbers with decimals (double).
     * @param max value for random numbers with decimals (double).
     * @return random number with decimals (double).
     */
    public static double randomDouble(double min, double max){

        return rnd.nextDouble() * (max - min) + min;
    }

    /**
     * Method to generate a random char from the ASCII Table.
     * Upper Case letters: 65 - 90
     * Lower Case letters: 97 - 122
     * For special characters check the ASCII Table www.asciitable.com
     * @param min int value for min.
     * @param max int value for max
     * @return int converted to char using a cast.
     */
    public static char randomChar(int min, int max) {

        return (char) (rnd.nextInt(max - min + 1) + min);
    }
}
