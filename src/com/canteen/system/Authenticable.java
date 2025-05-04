package com.canteen.system;

public interface Authenticable {
    boolean login(String username, String password);
    void logout();
    boolean isLoggedIn();  // New method to check login status
}