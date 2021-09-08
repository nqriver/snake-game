package com.myprojects.snake;

import javax.swing.*;
import javax.swing.InputMap;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SnakeGamePanel extends JPanel {

    Snake snake = new Snake();
    Food food = new Food(snake);


    SnakeGamePanel() {
        setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT));
        GameTimer timer = new GameTimer();
        timer.start();
        addBindings();
    }


    private void addBindings() {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");

        actionMap.put("RightArrow", new ArrowAction("RightArrow"));
        actionMap.put("LeftArrow", new ArrowAction("LeftArrow"));
        actionMap.put("UpArrow", new ArrowAction("UpArrow"));
        actionMap.put("DownArrow", new ArrowAction("DownArrow"));
        actionMap.put("Space", new ArrowAction("Space"));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Board.draw(graphics);
        snake.draw(graphics);
        food.draw(graphics);
    }

    private final int DELAY = 90;
    private class GameTimer extends Timer {

        public GameTimer() {
            super(DELAY, e -> {
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

    private class ArrowAction extends AbstractAction implements ActionListener {

        private final String cmd;

        public ArrowAction(String cmd) {
            this.cmd = cmd;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if ((cmd.equalsIgnoreCase("LeftArrow")) &&
                    snake.getDirection().compatibleWith(Direction.LEFT))
            {
                snake.setDirection(Direction.LEFT);
            }
            else if (cmd.equalsIgnoreCase("RightArrow") &&
                    snake.getDirection().compatibleWith(Direction.RIGHT))
            {
                snake.setDirection(Direction.RIGHT);
            }
            else if (cmd.equalsIgnoreCase("UpArrow") &&
                    snake.getDirection().compatibleWith(Direction.UP))
            {
                snake.setDirection(Direction.UP);
            }
            else if (cmd.equalsIgnoreCase("DownArrow") &&
                    snake.getDirection().compatibleWith(Direction.DOWN))
            {
                snake.setDirection(Direction.DOWN);
            }
        }
    }
}
