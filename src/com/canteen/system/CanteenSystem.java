package com.canteen.system;

import com.canteen.admin.Admin;
import com.canteen.admin.Staff;
import com.canteen.customer.CustomerConsole;
import java.util.Scanner;

public class CanteenSystem {
    private Scanner scanner;
    private Admin admin;
    private MenuManager menuManager;
    private OrderManager orderManager;
    private CustomerConsole customerConsole;
    private boolean systemRunning;

    public CanteenSystem() {
        this.scanner = new Scanner(System.in);
        this.admin = new Admin();
        this.menuManager = new MenuManager();
        this.orderManager = new OrderManager();
        this.customerConsole = new CustomerConsole(menuManager, orderManager, admin);
        this.systemRunning = true;
    }

    public void start() {
        while (systemRunning) {
            System.out.println("\n====================================");
            System.out.println("  COLLEGE CANTEEN MANAGEMENT SYSTEM  ");
            System.out.println("====================================");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Access");
            System.out.println("3. Exit System");
            System.out.print("Enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerConsole.showWelcome();
                    break;
                case 3:
                    systemRunning = false;
                    System.out.println("System shutting down...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void adminLogin() {
        System.out.print("\nEnter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            adminMenu();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private void adminMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Manage Staff");
            System.out.println("2. View Financial Reports");
            System.out.println("3. View All Orders");
            System.out.println("4. Logout");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageStaff();
                    break;
                case 2:
                    viewFinancialReports();
                    break;
                case 3:
                    viewAllOrders();
                    break;
                case 4:
                    loggedIn = false;
                    admin.logout();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void manageStaff() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("            STAFF MANAGEMENT");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("1. View All Staff");
        System.out.println("2. View Main Canteen Staff");
        System.out.println("3. View MBA Canteen Staff");
        System.out.println("4. View IT Canteen Staff");
        System.out.println("5. Add New Staff Member");
        System.out.println("6. Back");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 1:
                admin.viewStaff();
                break;
            case 2:
                admin.viewStaffByCanteen("Main Canteen");
                break;
            case 3:
                admin.viewStaffByCanteen("MBA Canteen");
                break;
            case 4:
                admin.viewStaffByCanteen("IT Canteen");
                break;
            case 5:
                addNewStaff();
                break;
        }
    }

    private void addNewStaff() {
        System.out.println("\nADD NEW STAFF MEMBER");
        System.out.println("──────────────────────");
        
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        
        System.out.print("Select canteen (1-Main, 2-MBA, 3-IT): ");
        int canteenChoice = scanner.nextInt();
        scanner.nextLine();
        String prefix = "";
        String canteen = "";
        switch(canteenChoice) {
            case 1: prefix = "MC"; canteen = "Main Canteen"; break;
            case 2: prefix = "MBA"; canteen = "MBA Canteen"; break;
            case 3: prefix = "IT"; canteen = "IT Canteen"; break;
            default: 
                System.out.println("Invalid choice, defaulting to Main Canteen");
                prefix = "MC";
                canteen = "Main Canteen";
        }
        
        String newId = admin.generateStaffId(prefix);
        
        System.out.print("Enter shift (e.g., 7:00-15:00): ");
        String shift = scanner.nextLine();
        
        System.out.print("Enter daily wage: ₹");
        double wage = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter role (Manager/Cashier/Cook/etc.): ");
        String role = scanner.nextLine();
        
        admin.addStaff(name, newId, shift, wage, role, canteen);
        System.out.printf("%nSuccessfully added %s (%s) to %s staff!%n", 
            name, newId, canteen);
    }

    private void viewFinancialReports() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           FINANCIAL MANAGEMENT");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("1. Daily Financial Summary");
        System.out.println("2. Staff Wages Breakdown");
        System.out.println("3. Add Other Expense");
        System.out.println("4. View Revenue Details");
        System.out.println("5. Back");
        System.out.print("Enter choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 1:
                System.out.println("\nDAILY FINANCIAL SUMMARY");
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-25s ₹%10.2f%n", "Total Revenue:", admin.getTotalRevenue());
                System.out.printf("%-25s ₹%10.2f%n", "Staff Wages:", admin.getDailyWages());
                System.out.printf("%-25s ₹%10.2f%n", "Other Expenses:", admin.getOtherExpenses());
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-25s ₹%10.2f%n", "Total Expenditure:", admin.getTotalExpenditure());
                System.out.printf("%-25s ₹%10.2f%n", "Daily Profit/Loss:", admin.getProfit());
                System.out.println("──────────────────────────────────────");
                break;
                
            case 2:
                System.out.println("\nSTAFF WAGES BREAKDOWN");
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-15s %12s%n", "CANTEEN", "DAILY WAGES");
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-15s ₹%10.2f%n", "Main Canteen", 
                    admin.getStaffList().stream()
                        .filter(s -> s.getCanteen().equals("Main Canteen"))
                        .mapToDouble(Staff::getDailyWage)
                        .sum());
                System.out.printf("%-15s ₹%10.2f%n", "MBA Canteen", 
                    admin.getStaffList().stream()
                        .filter(s -> s.getCanteen().equals("MBA Canteen"))
                        .mapToDouble(Staff::getDailyWage)
                        .sum());
                System.out.printf("%-15s ₹%10.2f%n", "IT Canteen", 
                    admin.getStaffList().stream()
                        .filter(s -> s.getCanteen().equals("IT Canteen"))
                        .mapToDouble(Staff::getDailyWage)
                        .sum());
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-15s ₹%10.2f%n", "TOTAL", admin.getDailyWages());
                break;
                
            case 3:
                System.out.print("Enter expense amount: ₹");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter expense description: ");
                String description = scanner.nextLine();
                admin.addOtherExpense(amount);
                System.out.printf("Added ₹%.2f for '%s' to expenses%n", amount, description);
                break;
                
            case 4:
                System.out.println("\nREVENUE DETAILS");
                System.out.println("──────────────────────────────────────");
                System.out.printf("%-25s ₹%10.2f%n", "Total Orders:", admin.getAllOrderRecords().size());
                System.out.printf("%-25s ₹%10.2f%n", "Total Revenue:", admin.getTotalRevenue());
                System.out.println("──────────────────────────────────────");
                break;
        }
    }
    
    private void viewAllOrders() {
        System.out.println("\n--- All Orders ---");
        orderManager.displayAllOrders();
    }
}