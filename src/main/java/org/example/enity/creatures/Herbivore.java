package org.example.enity.creatures;

import org.example.enity.Coordinates;
import org.example.enity.Creature;

public class Herbivore extends Creature{
    public Herbivore(Coordinates coordinates, int hp, int speed) {
        super(coordinates, hp, speed);
    }
    @Override
    public void makeMove() {
        // Реализация движения травоядного
    }
}
