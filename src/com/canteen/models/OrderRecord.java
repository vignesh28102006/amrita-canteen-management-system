package com.canteen.models;

public final class OrderRecord {
    private final Order order;
    private final double amount;

    public OrderRecord(Order order, double amount) {
        if (order == null) 
            throw new IllegalArgumentException("Order cannot be null");
        if (amount < 0) 
            throw new IllegalArgumentException("Amount cannot be negative");

        this.order = order;
        this.amount = amount;
    }

    // Getters
    public Order getOrder() { return order; }
    public double getAmount() { return amount; }
}