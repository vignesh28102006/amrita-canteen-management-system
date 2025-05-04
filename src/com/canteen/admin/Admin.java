package com.canteen.admin;

import com.canteen.models.*;
import com.canteen.system.Authenticable;
import java.util.*;

public final class Admin implements AdminOperations, Authenticable {
    private final List<Staff> staffList;
    private double totalDailyWages;
    private double otherExpenses;
    private double totalRevenue;
    private final List<OrderRecord> orderRecords;
    private boolean loggedIn;
    private final Map<String, String> expenseDescriptions;

    public Admin() {
        this.staffList = new ArrayList<>();
        this.orderRecords = new ArrayList<>();
        this.expenseDescriptions = new HashMap<>();
        initializeStaff();
    }

    private void initializeStaff() {
        // Initialize staff (same as before)
        // Main Canteen
        addStaff(new Staff("Ramesh Kumar", "MC001", "7:00-15:00", 1000, "Manager", "Main Canteen"));
        // ... rest of initialization
    }

    // ================== STAFF MANAGEMENT ==================
    @Override
    public void addStaff(Staff staff) {
        requireAdminLogin();
        validateStaff(staff);
        
        staffList.add(staff);
        totalDailyWages += staff.getDailyWage();
    }

    @Override
    public void removeStaff(String staffId) {
        requireAdminLogin();
        Staff staff = findStaffById(staffId);
        
        staffList.remove(staff);
        totalDailyWages -= staff.getDailyWage();
    }

    @Override
    public void updateStaff(String staffId, Staff updatedStaff) {
        requireAdminLogin();
        Staff existing = findStaffById(staffId);
        
        totalDailyWages -= existing.getDailyWage();
        staffList.remove(existing);
        
        validateStaff(updatedStaff);
        staffList.add(updatedStaff);
        totalDailyWages += updatedStaff.getDailyWage();
    }

    @Override
    public List<Staff> getAllStaff() {
        return Collections.unmodifiableList(staffList);
    }

    @Override
    public List<Staff> getStaffByCanteen(String canteen) {
        return staffList.stream()
            .filter(s -> s.getCanteen().equalsIgnoreCase(canteen))
            .toList();
    }

    // ================== ORDER MANAGEMENT ==================
    @Override
    public void addOrderRecord(OrderRecord record) {
        requireAdminLogin();
        validateOrderRecord(record);
        
        orderRecords.add(record);
        totalRevenue += record.getAmount();
    }

    @Override
    public List<OrderRecord> getAllOrderRecords() {
        return Collections.unmodifiableList(orderRecords);
    }

    // ================== FINANCIAL MANAGEMENT ==================
    @Override
    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public double getTotalExpenses() {
        return totalDailyWages + otherExpenses;
    }

    @Override
    public double getProfit() {
        return totalRevenue - getTotalExpenses();
    }

    @Override
    public void addExpense(double amount, String description) {
        requireAdminLogin();
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description required");
        }
        
        otherExpenses += amount;
        expenseDescriptions.put(UUID.randomUUID().toString(), 
            String.format("[₹%.2f] %s", amount, description));
    }

    // ================== AUTHENTICATION ==================
    @Override
    public boolean login(String username, String password) {
        if (username == null || password == null) return false;
        this.loggedIn = "admin".equals(username.trim()) && "admin123".equals(password);
        return loggedIn;
    }

    @Override
    public void logout() {
        this.loggedIn = false;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }

    // ================== HELPER METHODS ==================
    private void requireAdminLogin() {
        if (!isLoggedIn()) {
            throw new SecurityException("Admin authentication required");
        }
    }

    private Staff findStaffById(String staffId) {
        return staffList.stream()
            .filter(s -> s.getId().equals(staffId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Staff not found"));
    }

    private void validateStaff(Staff staff) {
        if (staff == null) throw new IllegalArgumentException("Staff cannot be null");
        if (staff.getDailyWage() <= 0) {
            throw new IllegalArgumentException("Wage must be positive");
        }
        // Add other validations as needed
    }

    private void validateOrderRecord(OrderRecord record) {
        if (record == null) throw new IllegalArgumentException("Record cannot be null");
        if (record.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public void printFinancialReport() {
        System.out.println("\n=== FINANCIAL REPORT ===");
        System.out.printf("Total Revenue: ₹%.2f%n", totalRevenue);
        System.out.printf("Staff Wages: ₹%.2f%n", totalDailyWages);
        System.out.printf("Other Expenses: ₹%.2f%n", otherExpenses);
        System.out.printf("Total Profit: ₹%.2f%n", getProfit());
        
        if (!expenseDescriptions.isEmpty()) {
            System.out.println("\nExpense Details:");
            expenseDescriptions.forEach((id, desc) -> 
                System.out.printf("- %s%n", desc));
        }
    }
}