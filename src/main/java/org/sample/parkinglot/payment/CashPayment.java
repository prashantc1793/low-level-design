package org.sample.parkinglot.payment;

public class CashPayment implements Payment{
    double availableCash = 20000.0;
    @Override
    public boolean pay(double parkingCharges) {
        if(availableCash < parkingCharges) {
            System.out.println("Not enough cash. Please try some other mode of payment");
            return false;
        }
        System.out.println("Payment successfully made via cash...");
        availableCash = availableCash - parkingCharges;
        return true;
    }
}
