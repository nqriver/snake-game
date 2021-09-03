package com.myprojects.snake;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public boolean compatibleWith(Direction newDirection) {
        return (this.equals(UP) || this.equals(DOWN)) ? LEFT.equals(newDirection) || RIGHT.equals(newDirection)
                : UP.equals(newDirection) || DOWN.equals(newDirection);
    }
}
