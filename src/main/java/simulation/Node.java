package simulation;

import simulation.entity.Coordinates;

public class Node {
    private Coordinates coordinates;
    private Node cameFrom;
    private int g;
    private int h;

    public Node(Coordinates coordinates) {
        this(coordinates, null, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public Node(Coordinates coordinates, Node cameFrom, int g, int h) {
        this.coordinates = coordinates;
        this.cameFrom = cameFrom;
        this.g = g;
        this.h = h;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Node getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(Node cameFrom) {
        this.cameFrom = cameFrom;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return g + h;
    }
}
