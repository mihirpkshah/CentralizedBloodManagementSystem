package view;

import com.sun.tools.javac.Main;
import controller.DonorRegistrationController;
import model.Donor;
import javax.swing.*;
import java.awt.*;

public class DonorRegistrationPanel extends JPanel {
    private JTextField userIdField;
    private JTextField bloodGroupField;
    private JCheckBox standbyAvailableBox;
    private JButton registerButton, backButton;
    private JLabel statusLabel;
    private DonorRegistrationController controller;

    public DonorRegistrationPanel(MainFrame mainFrame) {
        this.controller = new DonorRegistrationController(this);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("User ID:"), gbc);
        gbc.gridx = 1;
        userIdField = new JTextField(10);
        add(userIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Blood Group:"), gbc);
        gbc.gridx = 1;
        bloodGroupField = new JTextField(5);
        add(bloodGroupField, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Standby Available:"), gbc);
        gbc.gridx = 1;
        standbyAvailableBox = new JCheckBox();
        add(standbyAvailableBox, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        registerButton = new JButton("Register Donor");
        add(registerButton, gbc);
        gbc.gridy = 4;
        statusLabel = new JLabel("");
        add(statusLabel, gbc);

        registerButton.addActionListener(e -> controller.handleRegister());

        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 0;           // column
        gbcBack.gridy = 5;           // row below statusLabel
        gbcBack.gridwidth = 2;       // span two columns
        gbcBack.insets = new Insets(5, 5, 5, 5);
        gbcBack.anchor = GridBagConstraints.SOUTH; // align to bottom
        gbcBack.fill = GridBagConstraints.HORIZONTAL; // optional: make button wide
        backButton = new JButton("Back");
        add(backButton, gbcBack);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public int getUserId() {
        return Integer.parseInt(userIdField.getText());
    }
    public String getBloodGroup() {
        return bloodGroupField.getText();
    }
    public boolean isStandbyAvailable() {
        return standbyAvailableBox.isSelected();
    }
    public void setStatus(String status) {
        statusLabel.setText(status);
    }
    public void clearForm() {
        userIdField.setText("");
        bloodGroupField.setText("");
        standbyAvailableBox.setSelected(false);
    }
}

