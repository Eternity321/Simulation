package simulation.entity.staticobjects;

import simulation.entity.Coordinates;
import simulation.entity.SimulationObject;

public abstract class StaticObject extends SimulationObject {
    private String objectType;

    public StaticObject(Coordinates coordinates, String objectType) {
        super(coordinates);
        this.objectType = objectType;
    }
}
