package view;

import controller.UserRegistrationController;
import javax.swing.*;
import java.awt.*;

public class UserRegistrationPanel extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField roleField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton registerButton;
    private JLabel statusLabel;
    private UserRegistrationController controller;

    public UserRegistrationPanel(MainFrame mainFrame) {
        this.controller = new UserRegistrationController(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(15);
        add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(15);
        add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Role (donor/hospital/bloodbank):"), gbc);
        gbc.gridx = 1;
        roleField = new JTextField(10);
        add(roleField, gbc);
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(10);
        add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 5;
        add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        addressField = new JTextField(15);
        add(addressField, gbc);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        registerButton = new JButton("Register User");
        add(registerButton, gbc);
        gbc.gridy = 7;
        statusLabel = new JLabel("");
        add(statusLabel, gbc);

        registerButton.addActionListener(e -> controller.handleRegister());

        JButton backButton = new JButton("Back");
        //add(backButton, GridBagConstraints.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public String getName() { return nameField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getPassword() { return new String(passwordField.getPassword()); }
    public String getRole() { return roleField.getText(); }
    public String getPhone() { return phoneField.getText(); }
    public String getAddress() { return addressField.getText(); }
    public void setStatus(String status) { statusLabel.setText(status); }
    public void clearForm() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        roleField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }
}

