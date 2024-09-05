package org.example;

public class Maze {
    private static final int Wall = 0;
    private static final int Path = 1;

    private int[][] layout = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
    };

    public void printMaze(int playerX, int playerY) {
        for (int y = 0; y < layout.length; y++) {
            for (int x = 0; x < layout[y].length; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else {
                    System.out.print(layout[y][x] == Wall ? "# " : ". ");
                }
            }
            System.out.println();
        }
    }

    public boolean isWall(int x, int y) {
        if (x < 0 || x >= layout[0].length || y < 0 || y >= layout.length) {
            return true;
        }
        return layout[y][x] == Wall;
    }
}