package org.sample.parkinglot.model;

public class Receipt {
    private final String id;
    private final Vehicle vehicle;
    private final PaymentDetail paymentDetail;
    private final double duration;
    private final double amountPaid;

    public Receipt(String id, Vehicle vehicle, PaymentDetail paymentDetail, double duration, double amountPaid) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentDetail = paymentDetail;
        this.duration = duration;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id='" + id + '\'' +
                ", vehicle=" + vehicle +
                ", paymentDetail=" + paymentDetail +
                ", duration=" + duration +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
