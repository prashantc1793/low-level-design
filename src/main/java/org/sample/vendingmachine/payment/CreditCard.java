package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public class CreditCard implements Payment {
    double creditLimit = 1000;

    @Override
    public boolean pay(double totalPrice, Item item) {
        if(totalPrice > creditLimit) {
            System.out.println("Insufficient credit limit in your credit card...");
            return false;
        }
        creditLimit = creditLimit - totalPrice;
        System.out.println("Payment successfully made via your Credit card");
        return true;
    }
}
