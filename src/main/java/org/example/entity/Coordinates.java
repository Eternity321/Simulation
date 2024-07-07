package org.example.entity;

import java.util.Objects;

public class Coordinates {
    public final int x; //file
    public final int y; //rank

    public Coordinates(int y, int x) {
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
