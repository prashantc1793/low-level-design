package org.sample.parkinglot;

import org.sample.parkinglot.enums.ParkingType;
import org.sample.parkinglot.enums.PaymentMode;
import org.sample.parkinglot.enums.VehicleType;
import org.sample.parkinglot.model.Level;
import org.sample.parkinglot.model.ParkingSpot;
import org.sample.parkinglot.model.Vehicle;
import org.sample.parkinglot.payment.PaymentFactory;
import org.sample.parkinglot.payment.PaymentStrategy;
import org.sample.parkinglot.service.ParkingService;
import org.sample.parkinglot.service.ParkingSpotService;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpotService parkingSpotService = new ParkingSpotService();
        PaymentFactory paymentFactory = new PaymentFactory();
        PaymentStrategy paymentStrategy = new PaymentStrategy();
        ParkingService parkingService = new ParkingService(parkingSpotService, paymentFactory, paymentStrategy);

        boolean spotAvailable = parkingSpotService.isSpotAvailable(VehicleType.CAR);
        System.out.println(spotAvailable);
        Map<Level, List<ParkingSpot>> availableParkingSpots = parkingSpotService.getAvailableParkingSpots(VehicleType.CAR);
        System.out.println("Available Parking slots " + availableParkingSpots.size());

        ParkingSpot parkingSpot = new ParkingSpot(null, ParkingType.CAR, null);
        Vehicle vehicle = new Vehicle("123", VehicleType.CAR, parkingSpot);

        parkingService.parkVehicle(vehicle);
        parkingSpotService.getAvailableParkingSpots(VehicleType.CAR);

        System.out.println("After parking a car, Available Parking slots = " + parkingSpotService.getAvailableParkingSpots(VehicleType.CAR).size());

        parkingService.unparkVehicle(vehicle, PaymentMode.CASH);
        System.out.println("After unpark " + parkingSpotService.getAvailableParkingSpots(VehicleType.CAR).size());

    }
}