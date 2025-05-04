package com.canteen.system;

import com.canteen.models.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public Order createOrder(User user, String canteen, List<OrderItem> items) {
        String orderId = "ORD" + String.format("%04d", orderCounter++);
        Order order = new Order(orderId, user, canteen, items);
        orders.add(order);
        return order;
    }

    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        
        System.out.printf("%-10s %-15s %-20s %-15s %-10s%n", 
            "Order ID", "Customer", "Canteen", "Time", "Items");
        
        for (Order order : orders) {
            System.out.printf("%-10s %-15s %-20s %-15s %-10d%n", 
                order.getOrderId(), 
                order.getUser().getName(), 
                order.getCanteen(), 
                order.getOrderTime().toString(), 
                order.getItems().size());
        }
    }
}