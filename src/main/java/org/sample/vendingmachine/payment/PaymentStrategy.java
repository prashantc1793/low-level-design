package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public class PaymentStrategy {
    private Payment payment;

    public boolean payment(Item item) {
        return payment.pay(item);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
