package org.example.entity;

import java.util.Objects;

public class Coordinates {
    public final Integer x; //file
    public final Integer y; //rank

    public Coordinates(Integer y, Integer x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(y, that.y) && Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
