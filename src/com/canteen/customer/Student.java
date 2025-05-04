package com.canteen.customer;

import com.canteen.models.User;

public final class Student extends User {
    private final String branch;

    public Student(String name, String rollNo, String branch) {
        super(name, rollNo);
        if (branch == null || branch.trim().isEmpty()) 
            throw new IllegalArgumentException("Branch cannot be empty");
        this.branch = branch.trim();
    }

    public String getBranch() { return branch; }

    @Override
    public String toString() {
        return String.format("Student[name=%s, id=%s, branch=%s]", 
            getName(), getId(), branch);
    }
}