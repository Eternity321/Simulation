package org.example;

import org.example.enity.World;
import org.example.enity.WorldConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.setWorldSize();
        world.setupStartSimulationObjectsPositions();
        WorldConsoleRenderer renderer = new WorldConsoleRenderer();
        renderer.render(world);
        int a = 123;
    }
}