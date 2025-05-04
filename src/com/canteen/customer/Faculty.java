package com.canteen.customer;

import com.canteen.models.User;

public final class Faculty extends User {
    public Faculty(String name, String facultyId) {
        super(name, facultyId);
        if (!facultyId.matches("[A-Z]{2,3}\\d{3}"))  // Example: "CS101"
            throw new IllegalArgumentException("Invalid faculty ID format");
    }

    @Override
    public String toString() {
        return String.format("Faculty[name=%s, id=%s]", getName(), getId());
    }
}