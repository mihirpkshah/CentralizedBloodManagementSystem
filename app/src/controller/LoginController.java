package controller;

import service.AuthService;
import view.LoginPanel;
import java.sql.SQLException;

public class LoginController {
    private AuthService authService;
    private LoginPanel loginPanel;

    public LoginController(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
        this.authService = new AuthService();
    }

    public void handleLogin() {
        String email = loginPanel.getEmail();
        String password = loginPanel.getPassword();
        try {
            if (authService.authenticate(email, password) != null) {
                loginPanel.setStatus("Login successful!");
                loginPanel.loginSuccess();
            } else {
                loginPanel.setStatus("Invalid credentials.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            loginPanel.setStatus("Database error.");
        }
    }
}

