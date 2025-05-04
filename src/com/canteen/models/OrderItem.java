package com.canteen.models;

public final class OrderItem {
    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        if (menuItem == null) 
            throw new IllegalArgumentException("Menu item cannot be null");
        if (quantity <= 0) 
            throw new IllegalArgumentException("Quantity must be positive");

        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // Getters
    public MenuItem getMenuItem() { return menuItem; }
    public int getQuantity() { return quantity; }

    public double getItemTotal() {
        return menuItem.getPrice() * quantity;
    }
}