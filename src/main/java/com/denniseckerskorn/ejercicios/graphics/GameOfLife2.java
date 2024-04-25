package com.denniseckerskorn.ejercicios.graphics;

import java.awt.*;
import java.util.Random;

public class GameOfLife2 {
    private final int width;
    private final int height;
    private final int cellSize;
    private final int[][] world;
    private final int[][] nextWorld;

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
        ruleSet();
        copyWorldBack();
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
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (world[y][x] == 1) {
                    int cellX = x * cellSize;
                    int cellY = y * cellSize;
                    g2.fillRect(cellX, cellY, cellSize, cellSize);
                }
            }
        }
    }

    private void copyWorld() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nextWorld[i][j] = world[i][j];
            }
        }
    }

    private void ruleSet() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int neighbors = countNeighbors(x, y);
                if (world[y][x] == 1) {
                    // Rule 1: Any live cell with fewer than two live neighbors dies.
                    // Rule 3: Any live cell with more than three live neighbors dies.
                    if (neighbors < 2 || neighbors > 3) {
                        nextWorld[y][x] = 0;
                    }
                } else {
                    // Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if (neighbors == 3) {
                        nextWorld[y][x] = 1;
                    }
                }
            }
        }
    }

    private int countNeighbors(int x, int y) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int newX = x + j;
                int newY = y + i;
                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    neighbors += world[newY][newX];
                }
            }
        }
        return neighbors;
    }

    public void copyWorldBack() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                world[i][j] = nextWorld[i][j];
            }
        }
    }
}
