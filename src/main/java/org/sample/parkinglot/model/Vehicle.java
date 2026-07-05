package org.sample.parkinglot.model;

import org.sample.parkinglot.enums.VehicleType;

public class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private ParkingSpot parkingSpot;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType, ParkingSpot parkingSpot) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSpot = parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
