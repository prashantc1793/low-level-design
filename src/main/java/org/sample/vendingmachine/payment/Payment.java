package org.sample.vendingmachine.payment;

import org.sample.vendingmachine.model.Item;

public interface Payment {
    boolean pay(double totalPrice, Item item);
}
