package org.sample.vendingmachine.service;

import org.sample.vendingmachine.model.Item;
import org.sample.vendingmachine.model.VendingMachine;
import org.sample.vendingmachine.payment.Payment;
import org.sample.vendingmachine.payment.PaymentFactory;
import org.sample.vendingmachine.payment.PaymentMode;
import org.sample.vendingmachine.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineService {
    private final VendingMachine vendingMachine;

    public VendingMachineService(
            VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void displayItems() {
        vendingMachine.getItems()
                .forEach(System.out::println);
    }

    public String addItem(Item item) {
        vendingMachine.getItems().add(item);
        return "Item Added";
    }

    public String purchaseItem(int itemId,
                               int quantity,
                               String paymentMode) {
        String response;
        response = vendingMachine.selectItem(itemId,
                quantity);
        if(!response.equals("Item Selected"))
            return response;
        response = vendingMachine.pay(paymentMode);
        if(!response.equals("Payment Successful"))
            return response;
        return vendingMachine.dispense();
    }
}
