package com.canteen.customer;


import com.canteen.admin.Admin;
import com.canteen.models.*;
import com.canteen.system.MenuManager;
import com.canteen.system.OrderManager;
import java.time.LocalTime;
import java.util.*;

public class CustomerConsole implements CustomerOperations {
    private Scanner scanner;
    private MenuManager menuManager;
    private OrderManager orderManager;
    private Admin admin;  // Add this field

    // Update constructor to include Admin
    public CustomerConsole(MenuManager menuManager, OrderManager orderManager, Admin admin) {
        this.scanner = new Scanner(System.in);
        this.menuManager = menuManager;
        this.orderManager = orderManager;
        this.admin = admin;  // Initialize admin
    }
    // ... rest of the class


    @Override
    public void showWelcome() {
        System.out.println("\n************************************");
        System.out.println("*                                  *");
        System.out.println("*   WELCOME TO COLLEGE CANTEEN     *");
        System.out.println("*                                  *");
        System.out.println("************************************");

        System.out.println("\nAre you a: ");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.print("Enter your choice (1-2): ");

        int userType = scanner.nextInt();
        scanner.nextLine();

        if (userType == 1) {
            handleStudentOrder();
        } else if (userType == 2) {
            handleFacultyOrder();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    @Override
    public void handleStudentOrder() {
        System.out.println("\nSTUDENT ORDERING SYSTEM");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your roll number (format CB.SC.U4CSE24265): ");
        String rollNo = scanner.nextLine();
        
        System.out.print("Enter your branch: ");
        String branch = scanner.nextLine();
        
        Student student = new Student(name, rollNo, branch);
        placeOrder(student);
    }

    @Override
    public void handleFacultyOrder() {
        System.out.println("\nFACULTY ORDERING SYSTEM");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your faculty ID: ");
        String facultyId = scanner.nextLine();
        
        Faculty faculty = new Faculty(name, facultyId);
        placeOrder(faculty);
    }

    @Override
    public void placeOrder(User user) {
        System.out.println("\nAvailable Canteens:");
        System.out.println("1. Main Canteen");
        System.out.println("2. MBA Canteen");
        System.out.println("3. IT Canteen");
        System.out.print("Select canteen (1-3): ");
        int canteenChoice = scanner.nextInt();
        scanner.nextLine();
        
        String canteen = "";
        switch (canteenChoice) {
            case 1: canteen = "Main Canteen"; break;
            case 2: canteen = "MBA Canteen"; break;
            case 3: canteen = "IT Canteen"; break;
            default:
                System.out.println("Invalid choice. Defaulting to Main Canteen.");
                canteen = "Main Canteen";
        }
        
        LocalTime now = LocalTime.now();
        String timeSlot = menuManager.getCurrentTimeSlot(now);
        
        System.out.println("\nCurrent Time: " + now);
        System.out.println("Current Menu: " + timeSlot + " Menu");
        menuManager.displayMenu(canteen, timeSlot);
        
        List<OrderItem> orderItems = new ArrayList<>();
        boolean ordering = true;
        while (ordering) {
            System.out.print("\nEnter item number to order (0 to finish): ");
            int itemChoice = scanner.nextInt();
            if (itemChoice == 0) {
                ordering = false;
                continue;
            }
            
            MenuItem[] currentMenu = menuManager.getMenu(canteen, timeSlot);
            if (itemChoice < 1 || itemChoice > currentMenu.length) {
                System.out.println("Invalid item number.");
                continue;
            }
            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            
            MenuItem selectedItem = currentMenu[itemChoice - 1];
            orderItems.add(new OrderItem(selectedItem, quantity));
        }
        
        if (orderItems.isEmpty()) {
            System.out.println("No items ordered. Returning to main menu.");
            return;
        }
        
        Order order = orderManager.createOrder(user, canteen, orderItems);
        
        // Display bill in tabular format
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   ORDER BILL - "+canteen.toUpperCase()+"                ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ Customer: " + padRight(user.getName(), 43) + "║");
        System.out.println("║ Time: " + padRight(now.toString(), 46) + "║");
        System.out.println("║ Order ID: " + padRight(order.getOrderId(), 42) + "║");
        System.out.println("╠══════════════════════════════╦════════╦══════╦══════════╣");
        System.out.println("║            ITEM              ║ PRICE  ║ QTY  ║  TOTAL   ║");
        System.out.println("╠══════════════════════════════╬════════╬══════╬══════════╣");
        
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            String itemName = item.getMenuItem().getName();
            if (item.getMenuItem().getType().contains("NV)")) {
                itemName += " ♦";
            }
            
            double price = item.getMenuItem().getPrice();
            int qty = item.getQuantity();
            double total = price * qty;
            subtotal += total;
            
            System.out.printf("║ %-28s ║ %6.2f ║ %4d ║ %8.2f ║%n",
                itemName, price, qty, total);
        }
        
        System.out.println("╠══════════════════════════════╩════════╩══════╩══════════╣");
        
        // Apply faculty discount if applicable
        if (user instanceof Faculty) {
            double discount = subtotal * 0.02;
            System.out.printf("║ %-48s %8.2f ║%n", "SUB TOTAL:", subtotal);
            System.out.printf("║ %-48s %8.2f ║%n", "FACULTY DISCOUNT (2%):", -discount);
            subtotal -= discount;
        }
        
        System.out.printf(" ║ %-48s %8.2f ║%n", "GRAND TOTAL:", subtotal);
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ NOTE: Collect within 15 mins or ₹500 fine will be applied║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // Add order to admin records
        admin.addOrderToRecords(order, subtotal);
    }

    // Helper method for formatting
    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}