package com.denniseckerskorn.ejercicios;

import com.denniseckerskorn.ejercicios.graphics.Game;
import com.denniseckerskorn.ejercicios.tema08.ejer05.Ejercicio05;
import com.denniseckerskorn.ejercicios.tema08.ejer06.Ejercicio06;
import com.denniseckerskorn.ejercicios.tema08.ejer07.GUIJuego;
import com.denniseckerskorn.ejercicios.tema08.ejer08.EncriptacionCesar;
import com.denniseckerskorn.ejercicios.tema08.ejer08.GUIEncryption;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //InterfaceCalculator interfaceCalculator = new InterfaceCalculator(600, 600);
        //Ejercicio01 ejercicio01 = new Ejercicio01();
        //Ejercicio02 ejercicio02 = new Ejercicio02();
        //Ejercicio03 ejercicio03 = new Ejercicio03();
        //Ejercicio04 ejercicio04 = new Ejercicio04();
        //Ejercicio05 ejercicio05 = new Ejercicio05();
        //Ejercicio06 ejercicio06 = new Ejercicio06();
        //GUIJuego guiJuego = new GUIJuego();
        /*
        EncriptacionCesar encriptacionCesar = new EncriptacionCesar("CAFE", 3);
        String mensajeEncriptado = encriptacionCesar.encriptar();
        String mensajeDesencriptado = encriptacionCesar.desencriptar(mensajeEncriptado);
        System.out.println(mensajeEncriptado);
        System.out.println(mensajeDesencriptado);
         */

        //GUIEncryption guiEncryption = new GUIEncryption();

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Game Of Life");

        Game game = new Game(1280, 960, 60);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
    }
}