package com.myprojects.snake;

import javax.swing.*;
import javax.swing.InputMap;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class SnakeGamePanel extends JPanel implements ActionListener {

    private GameManager gameManager = new GameManager();
    private JLabel score;
    private static final int DELAY = 80;



    SnakeGamePanel() {
        setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT));
        score = new JLabel("Score: ", SwingConstants.CENTER);
        score.setFont(new Font(score.getFont().getName(), Font.BOLD, 20));
        score.setForeground(Color.BLACK);
        add(score);
        Timer timer = new Timer(DELAY, this);
        timer.setInitialDelay(1000);
        timer.start();
        addBindings();
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        gameManager.renderGraphics(g2d);
        score.setText(gameManager.getScoreText());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameManager.isGameRunning()) {
            gameManager.gameLoop();
            repaint();
        }
    }

    ///Key strokes handlers

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


    private class ArrowAction extends AbstractAction implements ActionListener {

        private final String cmd;

        public ArrowAction(String cmd) {
            this.cmd = cmd;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if ((cmd.equalsIgnoreCase("LeftArrow"))) {
                gameManager.moveSnakeLeft();
            }
            else if (cmd.equalsIgnoreCase("RightArrow")) {
                gameManager.moveSnakeRight();
            }
            else if (cmd.equalsIgnoreCase("UpArrow")) {
                gameManager.moveSnakeUp();
            }
            else if (cmd.equalsIgnoreCase("DownArrow")) {
                gameManager.moveSnakeDown();
            }
        }
    }
}
