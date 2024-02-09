package org.example.enity;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class World {
    protected int width;
    protected int height;
    Random random = new Random();
    private int countObjects = 0;
    private HashMap<Coordinates, SimulationObject> simulationObjects = new HashMap<>();

    public void setSimulationObject(Coordinates coordinates, SimulationObject simulationObject){
        simulationObject.coordinates = coordinates;
        simulationObjects.put(coordinates, simulationObject);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !simulationObjects.containsKey(coordinates);
    }

    public SimulationObject getSimulationObject(Coordinates coordinates){
        return simulationObjects.get(coordinates);
    }

    public void setWorldSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width of the world: ");
        width = scanner.nextInt();
        System.out.print("Enter height of the world: ");
        height = scanner.nextInt();

        countObjects = Math.round((width * height) / 4);
    }


    public void setupStartSimulationObjectsPositions(){
        for (int i = 0; i < countObjects; i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            Coordinates coordinates = new Coordinates(randomX, randomY);
            SimulationObject simulationObject = new SimulationObject(coordinates);
            setSimulationObject(coordinates, simulationObject);
        }
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
