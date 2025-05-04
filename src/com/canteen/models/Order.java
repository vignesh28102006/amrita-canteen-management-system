package com.canteen.models;

import java.time.LocalTime;
import java.util.List;

public final class Order {
    private final String orderId;
    private final User user;
    private final String canteen;
    private final List<OrderItem> items;
    private final LocalTime orderTime;

    public Order(String orderId, User user, String canteen, List<OrderItem> items) {
        if (orderId == null || orderId.trim().isEmpty()) 
            throw new IllegalArgumentException("Order ID cannot be empty");
        if (user == null) 
            throw new IllegalArgumentException("User cannot be null");
        if (canteen == null || canteen.trim().isEmpty()) 
            throw new IllegalArgumentException("Canteen cannot be empty");
        if (items == null || items.isEmpty()) 
            throw new IllegalArgumentException("Order items cannot be empty");

        this.orderId = orderId;
        this.user = user;
        this.canteen = canteen;
        this.items = List.copyOf(items); // Immutable copy
        this.orderTime = LocalTime.now();
    }

    // Getters
    public String getOrderId() { return orderId; }
    public User getUser() { return user; }
    public String getCanteen() { return canteen; }
    public List<OrderItem> getItems() { return items; }
    public LocalTime getOrderTime() { return orderTime; }

    public double getTotalAmount() {
        return items.stream()
            .mapToDouble(item -> item.getMenuItem().getPrice() * item.getQuantity())
            .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return orderId.hashCode();
    }
}