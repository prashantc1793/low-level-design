package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public class Upi implements Payment {
    double balance = 1000;

    @Override
    public boolean pay(Item item) {
        if(item.getPrice() > balance) {
            System.out.println("Insufficient balance...");
            return false;
        }
        balance = balance - item.getPrice();
        System.out.println("Payment successfully made via UPI");
        return true;
    }
}
