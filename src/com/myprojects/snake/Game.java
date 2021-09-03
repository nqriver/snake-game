package com.myprojects.snake;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var gameFrame = new GameFrame();
            gameFrame.setVisible(true);
        });
    }
}

