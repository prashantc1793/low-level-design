package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public class PaymentStrategy {
    private Payment payment;

    public boolean payment(double totalPrice, Item item) {
        return payment.pay(totalPrice, item);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
