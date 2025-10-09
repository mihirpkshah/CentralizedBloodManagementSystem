package controller;

import model.User;
import service.UserService;
import view.UserRegistrationPanel;
import java.sql.SQLException;

public class UserRegistrationController {
    private UserService userService;
    private UserRegistrationPanel panel;

    public UserRegistrationController(UserRegistrationPanel panel) {
        this.panel = panel;
        this.userService = new UserService();
    }

    public void handleRegister() {
        try {
            String name = panel.getName();
            String email = panel.getEmail();
            String password = panel.getPassword();
            String role = panel.getRole();
            String phone = panel.getPhone();
            String address = panel.getAddress();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                panel.setStatus("All fields are required.");
                return;
            }
            // For demo, store password as plain text (replace with hash in production)
            User user = new User(0, name, email, password, role, phone, address);
            userService.addUser(user);
            panel.setStatus("User registered successfully.");
            panel.clearForm();
        } catch (SQLException e) {
            panel.setStatus("Database error.");
        }
    }
}

