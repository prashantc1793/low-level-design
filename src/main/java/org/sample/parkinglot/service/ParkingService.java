package org.sample.parkinglot.service;

import org.sample.parkinglot.enums.ParkingDay;
import org.sample.parkinglot.enums.PaymentMode;
import org.sample.parkinglot.enums.VehicleType;
import org.sample.parkinglot.model.ParkingSpot;
import org.sample.parkinglot.model.PaymentDetail;
import org.sample.parkinglot.model.Receipt;
import org.sample.parkinglot.model.Vehicle;
import org.sample.parkinglot.payment.Payment;
import org.sample.parkinglot.payment.PaymentFactory;
import org.sample.parkinglot.payment.PaymentStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.sample.parkinglot.enums.ParkingDay.WEEK_END;

public class ParkingService {
    private final ParkingSpotService parkingSpotService;
    private final PaymentFactory paymentFactory;
    private final PaymentStrategy paymentStrategy;

    public ParkingService(ParkingSpotService parkingSpotService, PaymentFactory paymentFactory, PaymentStrategy paymentStrategy) {
        this.parkingSpotService = parkingSpotService;
        this.paymentFactory = paymentFactory;
        this.paymentStrategy = paymentStrategy;
    }

    // park the vehicle
    public String parkVehicle(Vehicle vehicle) {
        // check if spot is available or not
        VehicleType vehicleType = vehicle.getVehicleType();
        boolean isSpotAvailable = parkingSpotService.isSpotAvailable(vehicleType);
        if(isSpotAvailable) return "No parking slot is available.";

        // assign parking slot to vehicle and update the parking status
        String parkingNumber = parkingSpotService.assignParkingSlot(vehicle);
        return "Vehicle has been parked at " + parkingNumber;
    }

    // unpark the vehicle
    public String unparkVehicle(Vehicle vehicle, PaymentMode paymentMode) {
        // mark the spot available
        boolean freeUpSpot = parkingSpotService.freeUpSpot(vehicle.getParkingSpot().getParkingNumber());
        if(!freeUpSpot) return "No slots are available";

        // calculate parking charges
        double parkingCharges = calculateParkingCharges(vehicle.getParkingSpot());
        Payment payment = paymentFactory.getFactory(paymentMode);
        paymentStrategy.setPayment(payment);
        boolean pay = paymentStrategy.pay(parkingCharges);
        if(!pay) return "Payment failed...";

        // generate receipt
        Receipt receipt = new Receipt(UUID.randomUUID().toString(), vehicle, new PaymentDetail(1, paymentMode), LocalDateTime.now().getHour() - vehicle.getParkingSpot().getParkedAt().getHour(), parkingCharges);
        System.out.println("Receipt generated : " + receipt);
        return "Vehicle exits successfully";
    }

    public double calculateParkingCharges(ParkingSpot parkingSpot) {
        long minutes = Duration.between(parkingSpot.getParkedAt(), LocalDateTime.now()).toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);
        return switch (parkingSpot.getParkingDay()) {
            case WEEK_DAY -> 50.0 * (double) hours;
            case WEEK_END -> 100.0 * (double) hours;
        };
    }



}
