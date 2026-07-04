package org.sample.vendingmachine.model;

import org.sample.vendingmachine.payment.PaymentMode;
import org.sample.vendingmachine.payment.PaymentStatus;

import java.time.LocalDateTime;

public class PaymentDetail {
    String id;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;

}
