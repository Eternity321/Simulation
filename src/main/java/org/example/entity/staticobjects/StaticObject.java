package org.example.entity.staticobjects;

import org.example.entity.Coordinates;
import org.example.entity.SimulationObject;

public abstract class StaticObject extends SimulationObject {
    private String objectType;

    public StaticObject(Coordinates coordinates, String objectType) {
        super(coordinates);
        this.objectType = objectType;
    }
}
