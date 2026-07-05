package org.sample.parkinglot.payment;

public class UpiPayment implements Payment{
    double availableBalance = 1000.0;
    @Override
    public boolean pay(double parkingCharges) {
        if(availableBalance < parkingCharges) {
            System.out.println("Not enough balance in your bank account. Please pay in cash");
            return false;
        }
        System.out.println("Payment successfully made via UPI...");
        availableBalance = availableBalance - parkingCharges;
        return true;
    }
}
