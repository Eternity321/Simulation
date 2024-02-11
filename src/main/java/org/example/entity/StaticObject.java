package org.example.entity;

public class StaticObject extends SimulationObject {
    private String objectType;

    public StaticObject(Coordinates coordinates, String objectType) {
        super(coordinates);
        this.objectType = objectType;
    }
}
