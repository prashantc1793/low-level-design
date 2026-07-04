package org.sample.vendingmachine.state;

import org.sample.vendingmachine.model.VendingMachine;

public interface MachineState {
    String selectItem(VendingMachine machine,
                      int itemId,
                      int quantity);

    String pay(VendingMachine machine,
               String paymentMode);

    String cancel(VendingMachine machine);

    String dispense(VendingMachine machine);
}
