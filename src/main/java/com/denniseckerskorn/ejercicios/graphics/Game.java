package com.denniseckerskorn.ejercicios.graphics;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {
    private final int width;
    private final int height;
    private final float fpsLimit;
    private Thread thread;
    private boolean finished;

    public Game(int width, int height, float fpsLimit) {
        this.width = width;
        this.height = height;
        this.fpsLimit = fpsLimit;
        this.finished = false;
        setDoubleBuffered(true); //Evitar flickering
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        final double NANOS_NETWEEN_UPDATES = 1_000_000_000 / fpsLimit;
        long currentFrame;
        long lastFrame = currentFrame = System.nanoTime();

        System.out.println("Iniciando hilo ...");
        while (!finished) {
            currentFrame = System.nanoTime();
            if (currentFrame - lastFrame > NANOS_NETWEEN_UPDATES) {
                processInput();
                update();
                draw();
                lastFrame = currentFrame;
            }
        }
    }

    private void draw() {

    }

    private void update() {
        // TODO: update

    }

    private void processInput() {
        // TODO: processInput
    }


}
