package org.sample.vendingmachine.state;

import org.sample.vendingmachine.payment.PaymentMode;
import org.sample.vendingmachine.model.VendingMachine;
import org.sample.vendingmachine.payment.Payment;
import org.sample.vendingmachine.payment.PaymentFactory;
import org.sample.vendingmachine.payment.PaymentStrategy;

public class ItemSelectedState implements MachineState {
    private final PaymentFactory paymentFactory;
    private final PaymentStrategy paymentStrategy;


    public ItemSelectedState(PaymentFactory paymentFactory, PaymentStrategy paymentStrategy) {
        this.paymentFactory = paymentFactory;
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public String selectItem(VendingMachine machine, int itemId, int quantity) {
        return "Item is already selected...";
    }

    @Override
    public String pay(VendingMachine machine, String paymentMode) {
        Payment payment = paymentFactory.getFactory(PaymentMode.valueOf(paymentMode.toUpperCase()));
        paymentStrategy.setPayment(payment);
        boolean pay = paymentStrategy.payment(machine.getSelectedItem());

        if(!pay) {
            machine.setCurrentState(new IdleState());
            return "Payment Failed";
        }

        machine.setCurrentState(
                new DispensingState());
        return "Payment Successful";

    }

    @Override
    public String cancel(VendingMachine machine) {
        machine.setCurrentState(new IdleState());
        machine.setSelectedItem(null);
        machine.setSelectedQuantity(0);
        return "Transaction has been cancelled";
    }

    @Override
    public String dispense(VendingMachine machine) {
        return "Please complete payment first";
    }
}
