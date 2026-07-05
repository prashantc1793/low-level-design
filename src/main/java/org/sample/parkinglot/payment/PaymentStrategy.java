package org.sample.parkinglot.payment;

public class PaymentStrategy {
    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean pay(double parkingCharges) {
        return payment.pay(parkingCharges);
    }
}
