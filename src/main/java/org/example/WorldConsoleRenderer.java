package org.example;

import org.example.entity.Coordinates;
import org.example.entity.SimulationObject;
import org.example.entity.World;
import org.example.entity.creatures.*;
import org.example.entity.staticobjects.*;


public class WorldConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BACKGROUND_COLOR = "\u001B[0;100m";

    public void render(World world) {
        int height = world.getHeight();
        int width = world.getWidth();

        for (int y = height; y >= 1; y--) {
            String line = "";
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (world.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getSimulationObjectSprite(world.getSimulationObject(coordinates));
                }
            }

            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite) {
        String result = sprite;
        result = ANSI_BACKGROUND_COLOR + result;
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite(" \uD83D\uDFEB ");
    }

    private String selectEmojiSpriteFromSimulationObject(SimulationObject simulationObject) {
        if (simulationObject == null) {
            return " ";
        } else if (simulationObject instanceof Herbivore) {
            return "\uD83D\uDC04";
        } else if (simulationObject instanceof Predator) {
            return "\uD83D\uDC06";
        } else if (simulationObject instanceof Grass) {
            return "\uD83C\uDF40";
        } else if (simulationObject instanceof Rock) {
            return "\uD83E\uDEA8";
        } else if (simulationObject instanceof Tree) {
            return "\uD83C\uDF34";
        } else {
            return " ";
        }
    }

    private String getSimulationObjectSprite(SimulationObject simulationObject) {
        return colorizeSprite(" " + selectEmojiSpriteFromSimulationObject(simulationObject) + " ");
    }
}