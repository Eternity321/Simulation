package org.example.enity;

public class StaticObject extends SimulationObject {
    private String objectType;

    public StaticObject(Coordinates coordinates, String objectType) {
        super(coordinates);
        this.objectType = objectType;
    }
}
