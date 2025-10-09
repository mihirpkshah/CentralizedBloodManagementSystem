package view;

import controller.HospitalRequestController;
import javax.swing.*;
import java.awt.*;

public class HospitalRequestPanel extends JPanel {
    private JTextField hospitalIdField;
    private JTextField bloodGroupField;
    private JTextField quantityField;
    private JButton requestButton;
    private JLabel statusLabel;
    private HospitalRequestController controller;

    public HospitalRequestPanel(MainFrame mainFrame) {
        this.controller = new HospitalRequestController(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Hospital ID:"), gbc);
        gbc.gridx = 1;
        hospitalIdField = new JTextField(10);
        add(hospitalIdField, gbc);
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
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        requestButton = new JButton("Request Blood");
        add(requestButton, gbc);
        gbc.gridy = 4;
        statusLabel = new JLabel("");
        add(statusLabel, gbc);

        requestButton.addActionListener(e -> controller.handleRequest());

        JButton backButton = new JButton("Back");
        //add(backButton, GridBagConstraints.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public int getHospitalId() { return Integer.parseInt(hospitalIdField.getText()); }
    public String getBloodGroup() { return bloodGroupField.getText(); }
    public int getQuantity() { return Integer.parseInt(quantityField.getText()); }
    public void setStatus(String status) { statusLabel.setText(status); }
    public void clearForm() {
        hospitalIdField.setText("");
        bloodGroupField.setText("");
        quantityField.setText("");
    }
}

