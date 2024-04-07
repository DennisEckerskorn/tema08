package com.denniseckerskorn.ejercicios.gameoflife;

import javax.swing.*;

public class LifeFrame extends JFrame {
    public LifeFrame() {
        add(new LifePanel());
        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
