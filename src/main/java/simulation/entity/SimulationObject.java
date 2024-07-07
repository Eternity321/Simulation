package simulation.entity;

public abstract class SimulationObject {
    public Coordinates coordinates;

    public SimulationObject(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
