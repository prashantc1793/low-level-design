package org.sample.parkinglot.payment;

import org.sample.parkinglot.enums.PaymentMode;

public class PaymentFactory {
    public Payment getFactory(PaymentMode paymentMode) {
        return switch (paymentMode) {
            case CASH -> new CashPayment();
            case UPI -> new UpiPayment();
        };
    }
}
