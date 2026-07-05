package org.sample.vendingmachine.state;

import org.sample.vendingmachine.model.Item;
import org.sample.vendingmachine.model.VendingMachine;

public class IdleState implements MachineState{
    @Override
    public String selectItem(VendingMachine machine, int itemId, int quantity) {
        for(Item item : machine.getItems()) {
            if (itemId == item.getId()) {
                if(quantity > item.getQuantity()) {
                    return "Out of stock...Please reduce the quantity to continue purchasing this item";
                }
                machine.setSelectedItem(item);
                machine.setSelectedQuantity(quantity);
                //machine.setCurrentState(new ItemSelectedState());
                return "Item Selected";
            }
        }
        return "No Item found...";
    }

    @Override
    public String pay(VendingMachine machine, String paymentMode) {
        return "Select the item first";
    }

    @Override
    public String cancel(VendingMachine machine) {
        return "No active transaction to cancel";
    }

    @Override
    public String dispense(VendingMachine machine) {
        return "No item is eligible for dispense";
    }
}
