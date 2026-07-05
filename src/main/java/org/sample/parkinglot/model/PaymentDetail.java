package org.sample.parkinglot.model;

import org.sample.parkinglot.enums.PaymentMode;

public class PaymentDetail {
    private final int id;
    private final PaymentMode paymentMode;

    public PaymentDetail(int id, PaymentMode paymentMode) {
        this.id = id;
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "id=" + id +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
