package org.sample.parkinglot.model;

import java.util.List;

public class ParkingLot {
    private final List<Level> levels;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    public List<Level> getLevels() {
        return levels;
    }
}
