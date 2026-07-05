package org.sample.parkinglot.model;

import java.util.List;

public class Level {
    private final int level;
    private final List<ParkingSpot> parkingSpotList;

    public Level(int level, List<ParkingSpot> parkingSpotList) {
        this.level = level;
        this.parkingSpotList = parkingSpotList;
    }

    public int getLevel() {
        return level;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
