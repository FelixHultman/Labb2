package org.example;

public class Item {
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
            System.out.println("You found an upgrade!, lets go Fight!");
            // Implement upgrade interaction logic
        }
    }

    public static class Monster extends Item {
        private int health;
        private int strength;

        public Monster(int x, int y, int health, int strength) {
            super(x, y);
            this.health = health;
            this.strength = strength;
        }

        @Override
        public void interact(Player player) {
            System.out.println("Oh pancake, its Voldermort!!");
        }
    }
}
