package org.sample.vendingmachine.service;

import org.sample.vendingmachine.model.Item;

public class PricingService {
    public double calculatePrice(Item item, int quantity) {
        return item.getPrice() * quantity;
    }
}
