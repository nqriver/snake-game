package com.myprojects.snake;

import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame() {
        add(new SnakeGamePanel());
        setTitle("com.myprojects.snake.Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
