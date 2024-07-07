package simulation.entity.creatures;

import simulation.AStarPathfinding;
import simulation.entity.Coordinates;
import simulation.entity.SimulationObject;
import simulation.entity.World;

import java.util.List;

public abstract class Creature extends SimulationObject {
    protected int hp;
    protected int speed;
    protected World world;

    public Creature(Coordinates coordinates, int hp, int speed, World world) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
        this.world = world;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    abstract public void makeMove();

    protected Coordinates findNearestTarget(Class<? extends SimulationObject> targetType) {
        Coordinates nearestTarget = null;
        int minDistance = Integer.MAX_VALUE;

        for (SimulationObject obj : world.getAllSimulationObjects()) {
            if (targetType.isInstance(obj)) {
                int distance = calculateManhattanDistance(obj.coordinates, this.coordinates);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTarget = obj.coordinates;
                }
            }
        }
        return nearestTarget;
    }

    protected void moveToTarget(Coordinates target) {
        List<Coordinates> path = AStarPathfinding.findPath(this.coordinates, target, world);
        if (!path.isEmpty() && path.size() > 1) {
            Coordinates nextMove = path.get(1);
            world.moveSimulationObject(this, nextMove);
        }
    }

    public int calculateManhattanDistance(Coordinates a, Coordinates b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
