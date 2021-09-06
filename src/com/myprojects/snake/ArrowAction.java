package com.myprojects.snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrowAction extends AbstractAction implements ActionListener {

    private String cmd;
    private Snake snake;

    public ArrowAction(String cmd, Snake snake) {
        this.cmd = cmd;
        this.snake = snake;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((cmd.equalsIgnoreCase("LeftArrow")) && snake.getDirection().compatibleWith(Direction.LEFT)) {
            snake.setDirection(Direction.LEFT);
        } else if (cmd.equalsIgnoreCase("RightArrow") && snake.getDirection().compatibleWith(Direction.RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        } else if (cmd.equalsIgnoreCase("UpArrow") && snake.getDirection().compatibleWith(Direction.UP)) {
            snake.setDirection(Direction.UP);
        } else if (cmd.equalsIgnoreCase("DownArrow") && snake.getDirection().compatibleWith(Direction.DOWN)) {
            snake.setDirection(Direction.DOWN);
        }
    }
}
