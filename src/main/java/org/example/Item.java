package org.example;


public abstract class Item {
    private int x;
    private int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void interact(Player player) {

    }

    public static class Treasure extends Item {
        public Treasure(int x, int y) {
            super(x, y);
        }

        @Override
        public void interact(Player player) {
            System.out.println("You found an expensive pokemon card! much $$$$");
        }
    }

    public static class Upgrade extends Item {

        public Upgrade(int x, int y) {
            super(x, y);
        }

        @Override
        public void interact(Player player) {
            System.out.println("You found an upgrade!, Now lets go Fight!");
            // Implement upgrade interaction logic
        }
    }

    public static class Monster extends Item implements Moveable {
        private int health;
        private int strength;
        private int moveCounter;

        public Monster(int x, int y, int health, int strength) {
            super(x, y);
            this.health = health;
            this.strength = strength;
            this.moveCounter = 0;
        }

        @Override
        public void interact(Player player) {
            System.out.println("Oh pancake, its Voldermort!!");
        }

        @Override
        public void move(String direction, Maze maze) {
            int newX = getX();
            int newY = getY();

            if (moveCounter % 2 == 0) {
                newY++;
            } else {
                newY--;
            }

            if (maze.isWall(newX, newY)) {
                System.out.println("Monster hit a wall!");
            } else {
                setX(newX);
                setY(newY);
                System.out.println("Monster is moving...");
            }

            moveCounter++;
            if (moveCounter > 2) {
                moveCounter = 0;
            }

        }

    }


}
