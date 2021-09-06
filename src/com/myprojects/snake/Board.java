package com.myprojects.snake;

import java.awt.*;

public class Board {
    public static final int X_FIELDS = 35;
    public static final int Y_FIELDS = 30;
    public static final int CELL_SIZE = 25;
    public static final int WIDTH = X_FIELDS * CELL_SIZE;
    public static final int HEIGHT = Y_FIELDS * CELL_SIZE;

    private static void drawWalls(Graphics g){
        g.setColor(new Color(100, 159, 189));
        g.fillRect(0, 0, WIDTH, CELL_SIZE);     //North wall
        g.fillRect(0, HEIGHT - CELL_SIZE, WIDTH, CELL_SIZE);    //South wall
        g.fillRect(0, CELL_SIZE, CELL_SIZE, HEIGHT - 2 * CELL_SIZE);     //West wall
        g.fillRect(WIDTH - CELL_SIZE, CELL_SIZE, CELL_SIZE, HEIGHT - 2 * CELL_SIZE); //East wall
    }

    public static void draw(Graphics g) {
        g.setColor(new Color(16, 16, 42));
        g.fillRect(0,0, WIDTH, HEIGHT);
        drawWalls(g);
    }
}
