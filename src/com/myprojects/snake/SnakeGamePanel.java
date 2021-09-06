package com.myprojects.snake;

import javax.swing.*;
import javax.swing.InputMap;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SnakeGamePanel extends JPanel {

    Snake snake = new Snake();
    Food food = new Food(snake);


    SnakeGamePanel() {
        setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT));
        GameTimer timer = new GameTimer();
        timer.start();

        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");

        actionMap.put("RightArrow", new ArrowAction("RightArrow", snake));
        actionMap.put("LeftArrow", new ArrowAction("LeftArrow", snake));
        actionMap.put("UpArrow", new ArrowAction("UpArrow", snake));
        actionMap.put("DownArrow", new ArrowAction("DownArrow", snake));
        actionMap.put("Space", new ArrowAction("Space", snake));



    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Board.draw(graphics);
        snake.draw(graphics);
        food.draw(graphics);
    }

    private class GameTimer extends Timer {

        public GameTimer() {
            super(90, e -> {
                if (!snake.checkCollision()) {
                    snake.move();
                    if (snake.eatFood(food)) {
                        food = new Food(snake);
                    }
                    repaint();

                }
                    });
        }
    }

}
