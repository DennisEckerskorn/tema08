package com.denniseckerskorn.ejercicios.interfacecalculator;

import javax.swing.*;
import java.awt.*;

public class InterfaceCalculator {
    public InterfaceCalculator() {
        JFrame calculator = new JFrame("Calculator");
        int width = 500;
        int height = 500;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        calculator.setSize(width, height);
        int x = (int)(dimension.getWidth() / 2f) - Math.round(width / 2f);
        int y = (int)(dimension.getHeight() / 2f) - Math.round(height / 2f);
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(4, 5);

        calculator.setBounds(x,y,width,height);
        calculator.setResizable(true);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);



    }




}
