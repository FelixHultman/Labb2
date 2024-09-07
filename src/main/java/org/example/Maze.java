package org.example;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private static final int Wall = 0;
    private static final int Path = 1;

    private int[][] layout = {
            {1, 0, 1, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1},
    };

    private List<Item> items = new ArrayList<Item>();

    public Maze() {
        items.add(new Item.Treasure(2, 2));
        items.add(new Item.Treasure(5, 2));
        items.add(new Item.Monster(2, 4, 5, 11));
    }

    public void printMaze(int playerX, int playerY) {
        for (int y = 0; y < layout.length; y++) {
            for (int x = 0; x < layout[y].length; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else if (isItemAt(x, y)) {
                    System.out.print("T ");
                } else {
                    System.out.print(layout[y][x] == Wall ? "# " : ". ");
                }
            }
            System.out.println();
        }
    }

    private boolean isItemAt(int x, int y) {
        for (Item item : items) {
            if (item.getX() == x && item.getY() == y) {
                return true;
            }
        }
        return false;
    }


    public boolean isWall(int x, int y) {
        if (x < 0 || x >= layout[0].length || y < 0 || y >= layout.length) {
            return true;
        }
        return layout[y][x] == Wall;
    }

    public void handleInteraction(int playerX, int playerY, Player player) {
        for (Item item : items) {
            if (item.getX() == playerX && item.getY() == playerY) {
                item.interact(player);
            }
        }
    }
}