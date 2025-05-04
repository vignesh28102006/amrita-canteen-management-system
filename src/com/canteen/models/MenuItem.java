package com.canteen.models;

public final class MenuItem {
    private final String id;
    private final String name;
    private final double price;
    private final String type;

    public MenuItem(String id, String name, double price, String type) {
        if (id == null || id.trim().isEmpty()) 
            throw new IllegalArgumentException("Menu item ID cannot be empty");
        if (name == null || name.trim().isEmpty()) 
            throw new IllegalArgumentException("Menu item name cannot be empty");
        if (price < 0) 
            throw new IllegalArgumentException("Price cannot be negative");
        if (type == null || type.trim().isEmpty()) 
            throw new IllegalArgumentException("Type cannot be empty");

        this.id = id.trim();
        this.name = name.trim();
        this.price = price;
        this.type = type.trim();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("%-5s | %-20s | ₹%-6.2f | %s", id, name, price, type);
    }
}