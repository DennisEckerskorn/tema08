package com.denniseckerskorn.ejercicios.graphics;

import java.awt.*;

public class GameOfLife2 {
    private final int width;
    private final int height;
    private final int cellSize;
    private int[][] world;
    private int[][] nextWorld;

    public GameOfLife2(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        world = new int[height][width];
        nextWorld = new int[height][width];
        initializeMatrix(world);
    }

    private void initializeMatrix(int[][] currentWorld) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void update() {
        //Simular una generación:
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        for (int i = 0; i < height; i += cellSize) {
            g2.drawLine(0, i, width, i);
        }

        for (int i = 0; i < width; i += cellSize) {
            g2.drawLine(i, 0, i, height);
        }

    }
}
