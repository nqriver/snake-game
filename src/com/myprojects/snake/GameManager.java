package com.myprojects.snake;

import java.awt.*;
import java.util.List;

public class GameManager {

    private Snake snake = new Snake();
    private Food food = new Food(snake);
    private boolean gameRunning;


    public GameManager() {
        gameRunning = true;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    private boolean checkCollisionWithBounds() {
        var head = snake.getHead();
        return  head.x == 0  ||
                head.x == Board.X_FIELDS - 1 ||
                head.y == 0 ||
                head.y == Board.Y_FIELDS - 1;
    }

    private boolean checkCollisionWithBody() {
        var head = snake.getHead();
        List<Point> tail = snake.getTail();
        for (var part : tail) {
            if (head.equals(part)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollisionWithFood() {
        return snake.getHead().equals(food);
    }

    public void handleCollisions() {
        if (checkCollisionWithBody() || checkCollisionWithBounds())
            gameRunning = false;

        if (checkCollisionWithFood()) {
            food = new Food(snake);
            snake.extend();
        }
    }

    public void gameLoop() {
        snake.move();
        handleCollisions();
    }

    public String getScoreText() {
        return "Score: " + snake.getSize();
    }

    public void renderGraphics(Graphics2D g) {
        Board.draw(g);
        food.draw(g);
        snake.draw(g);
    }

    public void moveSnakeUp() {
        snake.setDirection(Direction.UP);
    }

    public void moveSnakeDown() {
        snake.setDirection(Direction.DOWN);
    }

    public void moveSnakeRight() {
        snake.setDirection(Direction.RIGHT);
    }

    public void moveSnakeLeft() {
        snake.setDirection(Direction.LEFT);
    }
}
