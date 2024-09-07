package org.example;

public class Player {
    private String playerName;
    private int x;
    private int y;
    private int health;
    private int strength;

    public Player(String name, int startX, int startY) {
        this.playerName = name;
        this.x = startX;
        this.y = startY;
        this.health = 100;
        this.strength = 10;
    }

    public void move(String direction, Maze maze) {
        int newX = x;
        int newY = y;

        switch (direction.toLowerCase()) {
            case "w" -> newY--;
            case "s" -> newY++;
            case "a" -> newX--;
            case "d" -> newX++;
            default -> {
                System.out.println("Invalid direction");
            }
        }

        if (maze.isWall(newX, newY)) {
            System.out.println("You hit a wall!");
        } else {
            x = newX;
            y = newY;
            System.out.println("You are moving forward");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
