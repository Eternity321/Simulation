package org.example.entity;

abstract public class Creature extends SimulationObject {
    protected int hp;
    protected int speed;

    public Creature(Coordinates coordinates, int hp, int speed) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    abstract public void makeMove();
}
