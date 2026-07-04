package org.sample.vendingmachine.state;

import org.sample.vendingmachine.model.Item;
import org.sample.vendingmachine.model.Receipt;
import org.sample.vendingmachine.model.VendingMachine;

public class DispensingState implements MachineState{
    @Override
    public String selectItem(VendingMachine machine, int itemId, int quantity) {
        return "Please wait, item is dispensing";
    }

    @Override
    public String pay(VendingMachine machine, String paymentMode) {
        return "Payment has been made";
    }

    @Override
    public String cancel(VendingMachine machine) {
        return "Cancellation of item is not allowed";
    }

    @Override
    public String dispense(VendingMachine machine) {
        Item item =
                machine.getSelectedItem();

        item.setQuantity(
                item.getQuantity()
                        - machine.getSelectedQuantity());

        Receipt receipt = new Receipt();
        machine.setCurrentState(
                new IdleState());
        machine.setSelectedItem(null);
        machine.setSelectedQuantity(0);
        return "Item Dispensed Successfully";
    }
}
