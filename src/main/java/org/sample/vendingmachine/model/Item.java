package org.sample.vendingmachine.model;

public class Item {
    int id;
    String name;
    String description;
    double price;
    int quantity;

    public Item(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
