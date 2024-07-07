package org.example;

import org.example.entity.World;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        world.setWorldSize();
        world.setupRandomStartSimulationObjectsPositions();
        WorldConsoleRenderer renderer = new WorldConsoleRenderer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select simulation mode (1 - one step, 2 - to the end): ");
        int mode = scanner.nextInt();

        if (mode == 1) {
            boolean continueSimulation = true;
            while (continueSimulation) {
                renderer.render(world);
                world.simulateStep();
                if (world.isSimulationOver()) {
                    System.out.println("The simulation is complete.");
                    break;
                }
                System.out.print("Select an action (1 - take the next step, 2 - end the simulation, 3 - run the simulation to the end): ");
                int nextStep = scanner.nextInt();
                if (nextStep == 2) {
                    break;
                } else if (nextStep == 3) {
                    runSimulationToEnd(world, renderer);
                    continueSimulation = false;
                }
            }
        } else if (mode == 2) {
            runSimulationToEnd(world, renderer);
        } else {
            System.out.println("Invalid simulation mode.");
        }
    }

    private static void runSimulationToEnd(World world, WorldConsoleRenderer renderer) {
        while (!world.isSimulationOver()) {
            renderer.render(world);
            world.simulateStep();
            System.out.println(" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        renderer.render(world);
        System.out.println("The simulation is complete.");
    }
}
