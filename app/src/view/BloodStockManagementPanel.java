package view;

import controller.BloodStockManagementController;
import javax.swing.*;
import java.awt.*;

public class BloodStockManagementPanel extends JPanel {
    private JTextField bankIdField;
    private JTextField bloodGroupField;
    private JTextField quantityField;
    private JTextField expiryDateField;
    private JButton addButton;
    private JLabel statusLabel;
    private BloodStockManagementController controller;

    public BloodStockManagementPanel(MainFrame mainFrame) {
        this.controller = new BloodStockManagementController(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Bank ID:"), gbc);
        gbc.gridx = 1;
        bankIdField = new JTextField(10);
        add(bankIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Blood Group:"), gbc);
        gbc.gridx = 1;
        bloodGroupField = new JTextField(5);
        add(bloodGroupField, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        quantityField = new JTextField(5);
        add(quantityField, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Expiry Date (yyyy-mm-dd):"), gbc);
        gbc.gridx = 1;
        expiryDateField = new JTextField(10);
        add(expiryDateField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        addButton = new JButton("Add Blood Stock");
        add(addButton, gbc);
        gbc.gridy = 5;
        statusLabel = new JLabel("");
        add(statusLabel, gbc);

        addButton.addActionListener(e -> controller.handleAddStock());
        JButton backButton = new JButton("Back");
        //add(backButton, GridBagConstraints.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public int getBankId() { return Integer.parseInt(bankIdField.getText()); }
    public String getBloodGroup() { return bloodGroupField.getText(); }
    public int getQuantity() { return Integer.parseInt(quantityField.getText()); }
    public String getExpiryDate() { return expiryDateField.getText(); }
    public void setStatus(String status) { statusLabel.setText(status); }
    public void clearForm() {
        bankIdField.setText("");
        bloodGroupField.setText("");
        quantityField.setText("");
        expiryDateField.setText("");
    }
}

