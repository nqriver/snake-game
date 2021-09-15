package com.myprojects.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board {
    public static final int X_FIELDS = 35;
    public static final int Y_FIELDS = 30;
    public static final int CELL_SIZE = 25;
    public static final int WIDTH = X_FIELDS * CELL_SIZE;
    public static final int HEIGHT = Y_FIELDS * CELL_SIZE;

    private static BufferedImage background;
    static {
        try {
            background = ImageIO.read(new File("resources/background_3.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawWalls(Graphics g){
        g.setColor(new Color(100, 159, 189));
        g.fillRect(0, 0, WIDTH, CELL_SIZE);     //North wall
        g.fillRect(0, HEIGHT - CELL_SIZE, WIDTH, CELL_SIZE);    //South wall
        g.fillRect(0, CELL_SIZE, CELL_SIZE, HEIGHT - 2 * CELL_SIZE);     //West wall
        g.fillRect(WIDTH - CELL_SIZE, CELL_SIZE, CELL_SIZE, HEIGHT - 2 * CELL_SIZE); //East wall
    }

    public static void draw(Graphics2D g) {
        g.drawImage(background,0, 0, WIDTH, HEIGHT, null);
    }
}
