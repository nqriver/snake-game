package com.myprojects.snake;

import javax.swing.*;
import java.awt.*;

public class SnakeGamePanel extends JPanel {

    Snake snake = new Snake();


    SnakeGamePanel() {
        setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT));
        GameTimer timer = new GameTimer();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Board.draw(graphics);
        snake.draw(graphics);
    }

    private class GameTimer extends Timer {

        public GameTimer() {
            super(100, e -> {
                snake.move();
                repaint();
                    });
        }
    }
}
