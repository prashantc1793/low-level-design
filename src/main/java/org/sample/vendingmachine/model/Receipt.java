package org.sample.vendingmachine.model;

import org.sample.vendingmachine.state.ItemSelectedState;

import java.util.List;

public class Receipt {
    String id;
    Item item;
    private int quantity;
    private double totalAmount;
    PaymentDetail paymentDetail;
}
