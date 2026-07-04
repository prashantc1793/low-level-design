package org.sample.vendingmachine.model;

import org.sample.vendingmachine.state.MachineState;

import java.util.List;

public class VendingMachine {
    List<Item> items;
    MachineState currentState;
    Item selectedItem;
    int selectedQuantity;

    public List<Item> getItems() {
        return items;
    }

    public String selectItem(int itemId, int quantity) {
        return currentState.selectItem(this, itemId, quantity);
    }

    public String pay(String paymentMode) {
        return currentState.pay(this,
                paymentMode);
    }

    public String cancel() {
        return currentState.cancel(this);
    }

    public String dispense() {
        return currentState.dispense(this);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }
}
