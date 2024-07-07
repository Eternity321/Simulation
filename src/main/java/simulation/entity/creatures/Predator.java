package simulation.entity.creatures;

import simulation.entity.Coordinates;
import simulation.entity.SimulationObject;
import simulation.entity.World;

public class Predator extends Creature {
    public Predator(Coordinates coordinates, int hp, int speed, World world) {
        super(coordinates, hp, speed, world);
    }

    @Override
    public void makeMove() {
        Coordinates target = findNearestHerbivore();
        if (target != null) {
            moveToTarget(target);
        }
    }

    private Coordinates findNearestHerbivore() {
        Coordinates nearestHerbivore = null;
        int minDistance = Integer.MAX_VALUE;

        for (SimulationObject obj : world.getAllSimulationObjects()) {
            if (obj instanceof Herbivore) {
                Coordinates herbivoreCoords = obj.getCoordinates();
                int distance = calculateManhattanDistance(herbivoreCoords, this.coordinates);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestHerbivore = herbivoreCoords;
                }
            }
        }
        return nearestHerbivore;
    }
}
