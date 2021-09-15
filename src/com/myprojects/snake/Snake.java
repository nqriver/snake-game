package com.myprojects.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Snake {

    private List<Point> body;
    private Direction direction;
    private Point tailTip;


    public Snake() {
        body = new ArrayList<>();
        initBody();
        direction = Direction.RIGHT;
        tailTip = new Point();

    }

    private void initBody() {
        int midX = Board.X_FIELDS/2;
        int midY = Board.Y_FIELDS/2;
        body.add(new Point(midX, midY));
        body.add(new Point(midX + 1, midY));
    }

    public List<Point> getBody() {
        return body;
    }

    public List<Point> getTail() {
        return body.subList(1, body.size());
    }

    public Point getHead() {
        return body.get(0);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSize() {
        return body.size();
    }

    public void setDirection(Direction newDirection) {
        if (direction.compatibleWith(newDirection))
            direction = newDirection;
    }


    public void draw(Graphics2D graphics) {
        graphics.setColor(new Color (3, 45, 3));
        for (var point : getTail()) {
            graphics.fillRoundRect(point.x * Board.CELL_SIZE, point.y * Board.CELL_SIZE,
                    Board.CELL_SIZE, Board.CELL_SIZE, 12,12);
        }
        graphics.setColor(new Color (8, 130, 8));
        graphics.fillOval(getHead().x * Board.CELL_SIZE, getHead().y * Board.CELL_SIZE,
                Board.CELL_SIZE, Board.CELL_SIZE);
    }


    void move() {
        tailTip.setLocation(body.get(body.size()-1));
        for (int i = body.size()-1; i>0; i--) {
            body.get(i).setLocation(body.get(i-1));
        }

        switch(direction) {
            case UP -> getHead().y--;
            case DOWN -> getHead().y++;
            case LEFT -> getHead().x--;
            case RIGHT -> getHead().x++;
        }
    }


    public void extend() {
        body.add(new Point(tailTip));
    }
}
