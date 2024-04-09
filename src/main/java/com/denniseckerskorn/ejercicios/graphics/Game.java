package com.denniseckerskorn.ejercicios.graphics;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {
    private final int width;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;
    private final Ball ball;


    public Game(int width, int height, float fpsLimit) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        setDoubleBuffered(true); //Evitar flickering
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);
        ball = new Ball(10, 10, 30, 10, 10, Color.WHITE, width, height);

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

        ball.draw(g2);
    }

    private void update() {
        // TODO: update
        ball.update();
        System.out.println("hola");


    }

    private void processInput() {
        // TODO: processInput
    }

//LibGDX checkout
}
