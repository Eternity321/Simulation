package org.example.enity;

public class Creature extends SimulationObject {
    protected int hp;
    protected int speed;

    public Creature(Coordinates coordinates, int hp, int speed) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
    }
}
