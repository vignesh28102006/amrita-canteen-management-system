package com.canteen.models;

public abstract class User {
    private final String name;
    private final String id;

    public User(String name, String id) {
        if (name == null || name.trim().isEmpty()) 
            throw new IllegalArgumentException("Name cannot be empty");
        if (id == null || id.trim().isEmpty()) 
            throw new IllegalArgumentException("ID cannot be empty");

        this.name = name.trim();
        this.id = id.trim();
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}