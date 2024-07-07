package simulation.entity;

import org.example.entity.creatures.*;
import org.example.entity.staticobjects.*;
import simulation.entity.creatures.Creature;
import simulation.entity.creatures.Herbivore;
import simulation.entity.creatures.Predator;
import simulation.entity.staticobjects.Grass;
import simulation.entity.staticobjects.Rock;
import simulation.entity.staticobjects.Tree;

import java.util.*;

public class World {
    private int width;
    private int height;
    private final Random random = new Random();
    private final Map<Coordinates, SimulationObject> simulationObjects = new HashMap<>();

    public void setWorldSize() {
        Scanner scanner = new Scanner(System.in);
        final int minWidth = 10;
        final int maxWidth = 52;
        final int minHeight = 10;
        final int maxHeight = 100;

        do {
            System.out.print("Enter width of the world (10-52): ");
            width = scanner.nextInt();
        } while (width < minWidth || width > maxWidth);

        do {
            System.out.print("Enter height of the world (10-100): ");
            height = scanner.nextInt();
        } while (height < minHeight || height > maxHeight);
    }

    public void addSimulationObject(Coordinates coordinates, SimulationObject simulationObject) {
        simulationObjects.put(coordinates, simulationObject);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !simulationObjects.containsKey(coordinates);
    }

    public SimulationObject getSimulationObject(Coordinates coordinates) {
        return simulationObjects.getOrDefault(coordinates, null);
    }

    public Collection<SimulationObject> getAllSimulationObjects() {
        return simulationObjects.values();
    }

    public void setupRandomStartSimulationObjectsPositions() {
        int countObjects = Math.round((width * height) / 4);
        for (int i = 0; i < countObjects; i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            Coordinates coordinates = new Coordinates(randomY, randomX);
            SimulationObject simulationObject = generateRandomObject(coordinates);
            simulationObjects.put(coordinates, simulationObject);
        }
    }

    private SimulationObject generateRandomObject(Coordinates coordinates) {
        int entityType = random.nextInt(5);
        switch (entityType) {
            case 0:
                return new Herbivore(coordinates, 100, 1, this);
            case 1:
                return new Predator(coordinates, 150, 2, this);
            case 2:
                return new Tree(coordinates, "tree");
            case 3:
                return new Rock(coordinates, "rock");
            case 4:
                return new Grass(coordinates, "grass");
            default:
                return null;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void simulateStep() {
        List<SimulationObject> objects = new ArrayList<>(simulationObjects.values());
        for (SimulationObject obj : objects) {
            if (obj instanceof Creature) {
                Creature creature = (Creature) obj;
                if (creature.isAlive()) {
                    creature.makeMove();
                }
            }
        }
    }

    public void moveSimulationObject(Creature creature, Coordinates newCoordinates) {
        if (simulationObjects.containsKey(newCoordinates)) {
            SimulationObject objectAtNewCoordinates = simulationObjects.get(newCoordinates);
            if (objectAtNewCoordinates instanceof Creature) {
                Creature otherCreature = (Creature) objectAtNewCoordinates;
                if (otherCreature.isAlive()) {
                }
            }
        }
        simulationObjects.remove(creature.coordinates);
        creature.coordinates = newCoordinates;
        simulationObjects.put(newCoordinates, creature);
    }

    public boolean isSimulationOver() {
        boolean herbivoresAlive = false;
        boolean predatorsAlive = false;
        for (SimulationObject obj : simulationObjects.values()) {
            if (obj instanceof Herbivore) {
                herbivoresAlive = true;
            } else if (obj instanceof Predator) {
                predatorsAlive = true;
            }
        }
        return !herbivoresAlive || !predatorsAlive;
    }
}