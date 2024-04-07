package com.denniseckerskorn.ejercicios.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifePanel extends JPanel implements ActionListener {
    int xPanel = 1300;
    int yPanel = 700;
    int size = 10;
    int xWidth = xPanel / size;
    int yHeight = yPanel / size;
    int[][] life = new int[xWidth][yHeight];
    int[][] beforeLife = new int[xWidth][yHeight];
    boolean starts = true;

    public LifePanel() {
        setSize(xPanel, yPanel);
        setLayout(null);
        setBackground(Color.BLACK);
        new Timer(80, this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid(g);
        spawn();
        display(g);
    }

    private void grid(Graphics g) {
        g.setColor(Color.DARK_GRAY); //Grid color
        for (int i = 0; i < life.length; i++) {
            g.drawLine(0, i * size, xPanel, i * size); //row
            g.drawLine(i * size, 0, i * size, yPanel); //column
        }
    }

    private void spawn() {
        if (starts) {
            for (int x = 0; x < life.length; x++) {
                for (int y = 0; y < (yHeight); y++) {
                    if ((int) (Math.random() * 5) == 0) {
                        life[x][y] = 1;
                    }
                }
            }
            starts = false;
        }
    }

    private void display(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                if (life[x][y] == 1) {
                    g.fillRect(x * size, y * size, size, size);
                }
            }
        }
    }

    private int check(int x, int y) {
        int alive = 0;
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth) % xWidth][(y + yHeight - 1) % yHeight];

        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight) % yHeight];

        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight + 1) % yHeight];

        alive += life[(x + xWidth) % xWidth][(y + yHeight + 1) % yHeight];
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight + 1) % yHeight];
        return alive;
    }

    public void actionPerformed(ActionEvent e) {
        int[][] nextGeneration = new int[xWidth][yHeight];
        int alive;
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < (yHeight); y++) {
                alive = check(x, y);
                if (alive == 3) {
                    nextGeneration[x][y] = 1;
                } else if (alive == 2 && life[x][y] == 1) {
                    nextGeneration[x][y] = 1;
                } else {
                    nextGeneration[x][y] = 0;
                }
            }
        }
        //Update life with nextGeneration array
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < yHeight; y++) {
                life[x][y] = nextGeneration[x][y];
            }
        }
        repaint();

    }
}
