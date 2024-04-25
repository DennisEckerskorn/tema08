package com.denniseckerskorn.ejercicios.graphics;

import javax.swing.*;
import java.awt.*;

public class Game2 extends JPanel implements Runnable {
    private final int width;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;
    private final GameOfLife2 gameOfLife2;



    public Game2(int width, int height, float fpsLimit) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        setDoubleBuffered(true); //Evitar flickering
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        setFocusable(true);
        gameOfLife2 = new GameOfLife2(width, height, 10);

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        final double NANOS_BETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame;
        long lastFrame = currentFrame = System.nanoTime();

        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            if (currentFrame - lastFrame > NANOS_BETWEEN_UPDATES) {
                processInput();
                update();
                draw();
                lastFrame = currentFrame;
            }
        }
    }

    private void draw() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        gameOfLife2.draw(g2);

    }

    private void update() {
        // TODO: update
      gameOfLife2.update();
      repaint();
    }

    private void processInput() {
        // TODO: processInput
    }

//LibGDX checkout
}
