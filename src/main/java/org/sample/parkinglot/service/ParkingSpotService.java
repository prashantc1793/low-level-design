package org.sample.parkinglot.service;

import org.sample.parkinglot.enums.ParkingDay;
import org.sample.parkinglot.enums.ParkingType;
import org.sample.parkinglot.enums.Status;
import org.sample.parkinglot.enums.VehicleType;
import org.sample.parkinglot.model.Level;
import org.sample.parkinglot.model.ParkingLot;
import org.sample.parkinglot.model.ParkingSpot;
import org.sample.parkinglot.model.Vehicle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotService {
    ParkingSpot parkingSpot1 = new ParkingSpot("A1", ParkingType.TRUCK, Status.AVAILABLE);
    ParkingSpot parkingSpot2 = new ParkingSpot("A2", ParkingType.CAR, Status.AVAILABLE);
    ParkingSpot parkingSpot3 = new ParkingSpot("A3", ParkingType.TRUCK, Status.OCCUPIED);
    ParkingSpot parkingSpot4 = new ParkingSpot("A4", ParkingType.BIKE, Status.OCCUPIED);

    List<ParkingSpot> firstLevelParkingSpots = List.of(parkingSpot1, parkingSpot2, parkingSpot3, parkingSpot4);

    ParkingSpot parkingSpot5 = new ParkingSpot("B1", ParkingType.TRUCK, Status.OCCUPIED);
    ParkingSpot parkingSpot6 = new ParkingSpot("B2", ParkingType.CAR, Status.OCCUPIED);
    ParkingSpot parkingSpot7 = new ParkingSpot("B3", ParkingType.CAR, Status.AVAILABLE);
    ParkingSpot parkingSpot8 = new ParkingSpot("B4", ParkingType.BIKE, Status.AVAILABLE);
    List<ParkingSpot> secondLevelParkingSpots = List.of(parkingSpot5, parkingSpot6, parkingSpot7, parkingSpot8);

    Level level1 = new Level(1, firstLevelParkingSpots);
    Level level2 = new Level(2, secondLevelParkingSpots);

    ParkingLot parkingLot = new ParkingLot(List.of(level1, level2));

    public boolean isSpotAvailable(VehicleType vehicleType) {
        return getAvailableParkingSpots(vehicleType).isEmpty();
    }

    public String assignParkingSlot(Vehicle vehicle) {
        Map<Level, List<ParkingSpot>> map = getAvailableParkingSpots(vehicle.getVehicleType());

        ParkingSpot parkingSpot = map
                .values().stream().flatMap(List::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No Available parking slot found for vehicle type " +
                        vehicle.getVehicleType()));

        parkingSpot.setStatus(Status.OCCUPIED);
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        parkingSpot.setParkingDay(ParkingDay.from(dayOfWeek));
        parkingSpot.setParkedAt(LocalDate.now().atStartOfDay());
        vehicle.setParkingSpot(parkingSpot);
        return parkingSpot.getParkingNumber();
    }

    public Map<Level, List<ParkingSpot>> getAvailableParkingSpots(VehicleType vehicleType) {
        List<Level> levels = parkingLot.getLevels();
        Map<Level, List<ParkingSpot>> availableSpotMap = new HashMap<>();
        for(Level level : levels) {
            availableSpotMap.put(level, level.getParkingSpotList().stream().
                    filter(x -> Status.AVAILABLE.equals(x.getStatus())
                            && vehicleType.name().equals(x.getParkingType().name())).toList());
        }
        return availableSpotMap;
    }

    public Map<Level, List<ParkingSpot>> getOccupiedParkingSpots() {
        List<Level> levels = parkingLot.getLevels();
        Map<Level, List<ParkingSpot>> occupiedSlotMap = new HashMap<>();
        for(Level level : levels) {
            occupiedSlotMap.put(level, level.getParkingSpotList().stream().
                    filter(x -> Status.OCCUPIED.equals(x.getStatus())).toList());
        }
        return occupiedSlotMap;
    }

    public boolean freeUpSpot(String parkingNumber) {
        return getOccupiedParkingSpots().values().stream()
                .flatMap(List::stream)
                .filter(parkingSpot -> parkingNumber.equals(parkingSpot.getParkingNumber()))
                .findFirst()
                .map(spot -> {
                    spot.setStatus(Status.AVAILABLE);
                    return true;
                }).orElse(false);
    }
}
