package com.denniseckerskorn.ejercicios.graphics;

import java.awt.*;
import java.util.Random;

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
        initializeMatrix(nextWorld);
    }

    private void initializeMatrix(int[][] currentWorld) {
        Random rnd = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                currentWorld[i][j] = rnd.nextInt(2);
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
        //Simular una generación: Pasos a seguir: Copiar mundo, establecer reglas, actualizarMundo
        copyWorld();

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        for (int i = 0; i < height; i += cellSize) {
            g2.drawLine(0, i, width, i);
        }

        for (int i = 0; i < width; i += cellSize) {
            g2.drawLine(i, 0, i, height);
        }

        //Draws cells in grid if cell is alive
        g2.setColor(Color.GREEN);
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(world[y][x] == 1) {
                    int cellX = x * cellSize;
                    int cellY = y * cellSize;
                    g2.fillRect(cellX,cellY,cellSize,cellSize);
                }
            }
        }
    }

    private void copyWorld() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                nextWorld[i][j] = world[i][j];
            }
        }
    }

    private void ruleSet() {

    }
}
