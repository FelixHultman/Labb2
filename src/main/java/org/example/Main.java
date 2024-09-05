package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Maze maze = new Maze();
        Player player = new Player("Cis-Kingen", 0, 0);

        Scanner scanner = new Scanner(System.in);
        String command;

        maze.printMaze(player.getX(), player.getY());

        while (true) {
            System.out.println("Use W, A ,D and S to move in the maze. Write quit to end game");
            command = scanner.nextLine().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("Game ending, coward!");
                break;

            }

            player.move(command, maze);
            maze.printMaze(player.getX(), player.getY());

        }
        scanner.close();
    }
}
