package com.canteen;
import com.canteen.customer.*;
import com.canteen.models.*;
import com.canteen.admin.*;
import com.canteen.system.*;
import java.util.*;

public class Main implements AdminOperations, Authenticable {
    private List<Staff> staffList;
    private double totalDailyWages;
    private double otherExpenses;
    private double totalRevenue;
    private List<OrderRecord> orderRecords;
    private boolean loggedIn;

    public Main() {
        this.staffList = new ArrayList<>();
        this.totalDailyWages = 0;
        this.otherExpenses = 0;
        this.totalRevenue = 0;
        this.orderRecords = new ArrayList<>();
        this.loggedIn = false;
        initializeStaff();
    }

    private void initializeStaff() {
        // Main Canteen Staff (10 members)
        addStaff("Ramesh Kumar", "MC001", "7:00-15:00", 1000, "Manager", "Main Canteen");
        addStaff("Suresh Patel", "MC002", "7:00-15:00", 900, "Asst. Manager", "Main Canteen");
        addStaff("Priya Sharma", "MC003", "15:00-22:00", 850, "Head Chef", "Main Canteen");
        addStaff("Anjali Gupta", "MC004", "15:00-22:00", 800, "Sous Chef", "Main Canteen");
        addStaff("Vikram Singh", "MC005", "10:00-18:00", 750, "Cashier", "Main Canteen");
        addStaff("Neha Joshi", "MC006", "10:00-18:00", 700, "Cashier", "Main Canteen");
        addStaff("Rajesh Iyer", "MC007", "8:00-16:00", 650, "Cook", "Main Canteen");
        addStaff("Deepa Nair", "MC008", "12:00-20:00", 650, "Cook", "Main Canteen");
        addStaff("Arun Malik", "MC009", "9:00-17:00", 600, "Cleaner", "Main Canteen");
        addStaff("Meena Chopra", "MC010", "11:00-19:00", 600, "Cleaner", "Main Canteen");

        // MBA Canteen Staff (10 members)
        addStaff("Sanjay Verma", "MBA001", "7:00-15:00", 1100, "Manager", "MBA Canteen");
        addStaff("Kavita Reddy", "MBA002", "7:00-15:00", 950, "Asst. Manager", "MBA Canteen");
        addStaff("Alok Mishra", "MBA003", "15:00-22:00", 900, "Head Chef", "MBA Canteen");
        addStaff("Pooja Desai", "MBA004", "15:00-22:00", 850, "Sous Chef", "MBA Canteen");
        addStaff("Rahul Bose", "MBA005", "10:00-18:00", 800, "Cashier", "MBA Canteen");
        addStaff("Swati Kapoor", "MBA006", "10:00-18:00", 750, "Cashier", "MBA Canteen");
        addStaff("Manoj Tiwari", "MBA007", "8:00-16:00", 700, "Cook", "MBA Canteen");
        addStaff("Anita Rao", "MBA008", "12:00-20:00", 700, "Cook", "MBA Canteen");
        addStaff("Vishal Khanna", "MBA009", "9:00-17:00", 650, "Cleaner", "MBA Canteen");
        addStaff("Divya Menon", "MBA010", "11:00-19:00", 650, "Cleaner", "MBA Canteen");

        // IT Canteen Staff (10 members)
        addStaff("Amit Trivedi", "IT001", "7:00-15:00", 1200, "Manager", "IT Canteen");
        addStaff("Shweta Nair", "IT002", "7:00-15:00", 1000, "Asst. Manager", "IT Canteen");
        addStaff("Nitin Joshi", "IT003", "15:00-22:00", 950, "Head Chef", "IT Canteen");
        addStaff("Tanvi Malhotra", "IT004", "15:00-22:00", 900, "Sous Chef", "IT Canteen");
        addStaff("Rohit Shetty", "IT005", "10:00-18:00", 850, "Cashier", "IT Canteen");
        addStaff("Ananya Das", "IT006", "10:00-18:00", 800, "Cashier", "IT Canteen");
        addStaff("Karan Mehta", "IT007", "8:00-16:00", 750, "Cook", "IT Canteen");
        addStaff("Ishaani Roy", "IT008", "12:00-20:00", 750, "Cook", "IT Canteen");
        addStaff("Varun Kapoor", "IT009", "9:00-17:00", 700, "Cleaner", "IT Canteen");
        addStaff("Dia Mirza", "IT010", "11:00-19:00", 700, "Cleaner", "IT Canteen");
    }

    @Override
    public void addStaff(String name, String id, String workingHours, double dailyWage, String role, String canteen) {
        Staff staff = new Staff(name, id, workingHours, dailyWage, role, canteen);
        staffList.add(staff);
        totalDailyWages += dailyWage;
    }

    @Override
    public void viewStaff() {
        System.out.println("\nALL STAFF MEMBERS");
        System.out.println("════════════════════════════════════════════════════");
        System.out.printf("%-8s %-20s %-12s %-15s %-10s %-10s%n", 
            "ID", "NAME", "SHIFT", "CANTEEN", "ROLE", "DAILY WAGE");
        
        staffList.forEach(staff -> 
            System.out.printf("%-8s %-20s %-12s %-15s %-10s ₹%-9.2f%n",
                staff.getId(),
                staff.getName(),
                staff.getWorkingHours(),
                staff.getCanteen(),
                staff.getRole(),
                staff.getDailyWage()));
        
        System.out.println("\nTOTAL DAILY WAGES: ₹" + totalDailyWages);
    }

    @Override
    public void viewStaffByCanteen(String canteen) {
        double canteenTotal = staffList.stream()
            .filter(s -> s.getCanteen().equals(canteen))
            .mapToDouble(Staff::getDailyWage)
            .sum();
        
        System.out.printf("%n--- %s STAFF (DAILY WAGES: ₹%.2f) ---%n", 
            canteen.toUpperCase(), canteenTotal);
        System.out.printf("%-5s %-20s %-12s %-10s %-10s%n", 
            "ID", "NAME", "SHIFT", "ROLE", "WAGE");
        
        staffList.stream()
            .filter(staff -> staff.getCanteen().equals(canteen))
            .forEach(staff -> 
                System.out.printf("%-5s %-20s %-12s %-10s ₹%-9.2f%n",
                    staff.getId(),
                    staff.getName(),
                    staff.getWorkingHours(),
                    staff.getRole(),
                    staff.getDailyWage()));
    }

    @Override
    public void addOrderToRecords(Order order, double amount) {
        orderRecords.add(new OrderRecord(order, amount));
        totalRevenue += amount;
    }

    @Override
    public List<OrderRecord> getAllOrderRecords() {
        return Collections.unmodifiableList(orderRecords);
    }

    @Override
    public double getTotalExpenditure() {
        return totalDailyWages + otherExpenses;
    }

    @Override
    public double getDailyWages() {
        return totalDailyWages;
    }

    @Override
    public double getOtherExpenses() {
        return otherExpenses;
    }

    @Override
    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public double getProfit() {
        return totalRevenue - getTotalExpenditure();
    }

    @Override
    public void addOtherExpense(double amount) {
        otherExpenses += amount;
    }

    @Override
    public boolean login(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            loggedIn = true;
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        loggedIn = false;
    }

    public String generateStaffId(String prefix) {
        long count = staffList.stream()
                .filter(s -> s.getId().startsWith(prefix))
                .count();
        return prefix + String.format("%03d", count + 1);
    }

    public List<Staff> getStaffList() {
        return Collections.unmodifiableList(staffList);
    }
}