package org.example.entity.creatures;

import org.example.entity.Coordinates;
import org.example.entity.Creature;

public class Predator extends Creature{
    public Predator(Coordinates coordinates, int hp, int speed) {
        super(coordinates, hp, speed);
    }
    @Override
    public void makeMove() {
        // Реализация движения хищника
    }
}
