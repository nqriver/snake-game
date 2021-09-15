package com.myprojects.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Food extends Point {

    private static BufferedImage apple;

    static {
        try {
            apple = ImageIO.read(new File("resources/apple.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public Food(Snake snake) {
        boolean overlapsSnake = true;
        int tempX = 1, tempY = 1;
        while (overlapsSnake) {
            tempY = ThreadLocalRandom.current().nextInt(1, Board.Y_FIELDS - 1);
            tempX = ThreadLocalRandom.current().nextInt(1, Board.X_FIELDS - 1);
            overlapsSnake = snake.getBody().contains(new Point(tempX, tempY));
        }
        this.x = tempX;
        this.y = tempY;
    }

    public void draw(Graphics2D graphics) {
        graphics.drawImage(apple, x * Board.CELL_SIZE, y * Board.CELL_SIZE,
                Board.CELL_SIZE, Board.CELL_SIZE,  null);
    }
}
