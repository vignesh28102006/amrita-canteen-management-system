package com.canteen.admin;

import com.canteen.models.*;

import java.util.List;

public interface AdminOperations {
    // Staff Management
    void addStaff(Staff staff);
    void removeStaff(String staffId);
    void updateStaff(String staffId, Staff updatedDetails);
    List<Staff> getAllStaff();
    List<Staff> getStaffByCanteen(String canteen);

    // Order Management
    void addOrderRecord(OrderRecord record);
    List<OrderRecord> getAllOrderRecords();

    // Financials
    double getTotalRevenue();
    double getTotalExpenses();
    double getProfit();
    void addExpense(double amount, String description);
}