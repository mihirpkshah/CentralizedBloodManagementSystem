package view;

import controller.LoginController;
import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private MainFrame mainFrame;
    private LoginController controller;

    public LoginPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.controller = new LoginController(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        loginButton = new JButton("Login");
        add(loginButton, gbc);
        gbc.gridy = 3;
        statusLabel = new JLabel("");
        add(statusLabel, gbc);

        loginButton.addActionListener(e -> controller.handleLogin());
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void loginSuccess() {
        mainFrame.showDashboard();
    }
}

