package org.example;

import org.example.entity.World;
import org.example.entity.WorldConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.setWorldSize();
        world.setupRandomStartSimulationObjectsPositions();
        WorldConsoleRenderer renderer = new WorldConsoleRenderer();
        renderer.render(world);
        int a = 123;
    }
}