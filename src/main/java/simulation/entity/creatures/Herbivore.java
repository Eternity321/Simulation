package simulation.entity.creatures;

import simulation.entity.Coordinates;
import simulation.entity.SimulationObject;
import simulation.entity.staticobjects.Grass;
import simulation.entity.World;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int hp, int speed, World world) {
        super(coordinates, hp, speed, world);
    }

    @Override
    public void makeMove() {
        Coordinates target = findNearestGrass();
        if (target != null) {
            moveToTarget(target);
        }
    }

    private Coordinates findNearestGrass() {
        Coordinates nearestGrass = null;
        int minDistance = Integer.MAX_VALUE;

        for (SimulationObject obj : world.getAllSimulationObjects()) {
            if (obj instanceof Grass) {
                Coordinates grassCoords = obj.getCoordinates();
                int distance = calculateManhattanDistance(grassCoords, this.coordinates);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestGrass = grassCoords;
                }
            }
        }
        return nearestGrass;
    }
}
