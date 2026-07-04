package org.sample.vendingmachine.payment;

public class PaymentFactory {
    public Payment getFactory(PaymentMode mode) {
        return switch (mode) {
            case UPI -> new Upi();
            case CREDIT_CARD -> new CreditCard();
            case DEBIT_CARD -> new DebitCard();
        };
    }
}
