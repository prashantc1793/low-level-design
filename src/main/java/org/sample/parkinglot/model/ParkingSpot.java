package org.sample.parkinglot.model;

import org.sample.parkinglot.enums.ParkingDay;
import org.sample.parkinglot.enums.ParkingType;
import org.sample.parkinglot.enums.Status;

import java.time.LocalDateTime;

public class ParkingSpot {
    private final String parkingNumber;
    private final ParkingType parkingType;
    private Status status;
    private ParkingDay parkingDay;
    private LocalDateTime parkedAt;


    public ParkingSpot(String parkingNumber, ParkingType parkingType, Status status) {
        this.parkingNumber = parkingNumber;
        this.parkingType = parkingType;
        this.status = status;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setParkingDay(ParkingDay parkingDay) {
        this.parkingDay = parkingDay;
    }

    public void setParkedAt(LocalDateTime parkedAt) {
        this.parkedAt = parkedAt;
    }

    public LocalDateTime getParkedAt() {
        return parkedAt;
    }

    public ParkingDay getParkingDay() {
        return parkingDay;
    }



    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingNumber='" + parkingNumber + '\'' +
                ", parkingType=" + parkingType +
                ", status=" + status +
                ", parkingDay=" + parkingDay +
                ", parkedAt=" + parkedAt +
                '}';
    }
}
