package com.myprojects.snake;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Food extends Point {


    public Food(Snake snake) {

        boolean overlapsSnake = true;
        int tempX = 1, tempY = 1;
        while (overlapsSnake) {
            tempX = ThreadLocalRandom.current().nextInt(1, Board.X_FIELDS - 1);
            tempY = ThreadLocalRandom.current().nextInt(1, Board.Y_FIELDS - 1);
            overlapsSnake = snake.getBody().contains(new Point(tempX, tempY));
        }
        this.x = tempX;
        this.y = tempY;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(x * Board.CELL_SIZE, y * Board.CELL_SIZE, Board.CELL_SIZE, Board.CELL_SIZE);
    }
}
