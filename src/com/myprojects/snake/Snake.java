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
        body.add(new Point(Board.X_FIELDS /2, Board.Y_FIELDS /2));
        body.add(new Point(Board.X_FIELDS /2 + 1, Board.Y_FIELDS /2));
        direction = Direction.RIGHT;
        tailTip = body.get(body.size() - 1);
    }

    public List<Point> getTail() {
        return body.subList(1, body.size());
    }

    public Point getHead() {
        return body.get(0);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }


    public void draw(Graphics graphics) {
        graphics.setColor(new Color (3, 45, 3));
        for (var point : getTail()) {
            graphics.fillRect(point.x * Board.CELL_SIZE, point.y * Board.CELL_SIZE,
                    Board.CELL_SIZE, Board.CELL_SIZE);
        }
        graphics.setColor(new Color (8, 130, 8));
        graphics.fillRect(getHead().x * Board.CELL_SIZE, getHead().y * Board.CELL_SIZE,
                Board.CELL_SIZE, Board.CELL_SIZE);

    }

    void move() {
        tailTip.setLocation(body.get(body.size()-1));
        for (int i = 1; i < body.size(); i++) {
            body.get(i).setLocation(body.get(i-1));
        }

        switch(direction) {
            case UP -> getHead().y--;
            case DOWN -> getHead().y++;
            case LEFT -> getHead().x--;
            case RIGHT -> getHead().x++;
        }

    }
}
