package org.example.entity;

import org.example.entity.creatures.*;
import org.example.entity.staticobjects.*;


public class WorldConsoleRenderer   {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BACKGROUND_COLOR = "\u001B[0;100m";

    public void render(World world){
        int height = world.getHeight();
        int width = world.getWidth();

        for (int y = height; y >= 1; y--) {
            String line = "";
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if(world.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getSimulationObjectSprite(world.getSimulationObject(coordinates));
                }
            }

            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite){
        String result = sprite;
        result = ANSI_BACKGROUND_COLOR + result;
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates){
        return colorizeSprite("   ");
    }

    private String selectEmojiSpriteFromSimulationObject(SimulationObject simulationObject) {
        if (simulationObject == null) {
            return " ";
        } else if (simulationObject instanceof Herbivore) {
            return "H";
        } else if (simulationObject instanceof Predator) {
            return "P";
        } else if (simulationObject instanceof Grass) {
            return "G";
        } else if (simulationObject instanceof Rock) {
            return "R";
        } else if (simulationObject instanceof Tree) {
            return "T";
        } else {
            return " ";
        }
    }

    private String getSimulationObjectSprite(SimulationObject simulationObject) {
        return colorizeSprite(" " + selectEmojiSpriteFromSimulationObject(simulationObject) + " ");
    }
}
