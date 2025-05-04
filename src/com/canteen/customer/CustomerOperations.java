package com.canteen.customer;

import com.canteen.models.User;

public interface CustomerOperations {
    void showWelcome();
    void handleStudentOrder();
    void handleFacultyOrder();
    void placeOrder(User user);
}