package com.canteen.admin;

public class Staff {
    private String name;
    private String id;
    private String workingHours;
    private double dailyWage;
    private String role;
    private String canteen;

    public Staff(String name, String id, String workingHours, double dailyWage, String role, String canteen) {
        this.name = name;
        this.id = id;
        this.workingHours = workingHours;
        this.dailyWage = dailyWage;
        this.role = role;
        this.canteen = canteen;
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }
    public String getWorkingHours() { return workingHours; }
    public double getDailyWage() { return dailyWage; }
    public String getRole() { return role; }
    public String getCanteen() { return canteen; }
}