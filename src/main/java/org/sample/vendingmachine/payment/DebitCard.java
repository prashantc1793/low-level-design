package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public class DebitCard implements Payment {
    double availableLimit = 1000;

    public double getAvailableLimit() {
        return availableLimit;
    }

    @Override
    public boolean pay(Item item) {
        if(item.getPrice() > availableLimit) {
            System.out.println("Insufficient limit in your Debit card...");
            return false;
        }
        availableLimit = availableLimit - item.getPrice();
        System.out.println("Payment successfully made via your Dedit card");
        return true;
    }
}
