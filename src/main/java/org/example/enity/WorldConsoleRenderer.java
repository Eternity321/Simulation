package org.example.enity;

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

    private String selectEmojiSpriteFromSimulationObject(SimulationObject simulationObject){
        switch (simulationObject.getClass().getName()){
            case "Herbivore":
                return "\uD83D\uDC04";
            case "Predator":
                return "\uD83D\uDC06";
            case "Grass":
                return "\uD83C\uDF3E";
            case "Rock":
                return "⛰";
            case "Tree":
                return "\uD83C\uDF34";
        }
        return "⛰";
    }

    private String getSimulationObjectSprite(SimulationObject simulationObject) {
        return colorizeSprite(" " + selectEmojiSpriteFromSimulationObject(simulationObject) + " ");
    }
}
