package org.example.entity;

abstract public class SimulationObject {
    public Coordinates coordinates;

    public SimulationObject(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
