package view;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JButton donorRegistrationButton;
    private JButton bloodStockManagementButton;
    private JButton hospitalRequestButton;
    private JButton userRegistrationButton;
    private JButton viewRequestsButton;
    private JButton viewDonorsButton;
    private JButton viewBloodStockButton;
    private JButton logoutButton;
    private JButton analyticsDashboardButton;
    private MainFrame mainFrame;

    public DashboardPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout());
        donorRegistrationButton = new JButton("Donor Registration");
        bloodStockManagementButton = new JButton("Blood Stock Management");
        hospitalRequestButton = new JButton("Hospital Blood Request");
        userRegistrationButton = new JButton("User Registration");
        viewRequestsButton = new JButton("View Requests");
        viewDonorsButton = new JButton("View Donors");
        viewBloodStockButton = new JButton("View Blood Stock");
        logoutButton = new JButton("Logout");
        analyticsDashboardButton = new JButton("Analytics Dashboard");
        add(donorRegistrationButton);
        add(bloodStockManagementButton);
        add(hospitalRequestButton);
        add(userRegistrationButton);
        add(viewRequestsButton);
        add(viewDonorsButton);
        add(viewBloodStockButton);
        add(logoutButton);
        add(analyticsDashboardButton);

        donorRegistrationButton.addActionListener(e -> mainFrame.showDonorRegistration());
        bloodStockManagementButton.addActionListener(e -> mainFrame.showBloodStockManagement());
        hospitalRequestButton.addActionListener(e -> mainFrame.showHospitalRequest());
        userRegistrationButton.addActionListener(e -> mainFrame.showUserRegistration());
        viewRequestsButton.addActionListener(e -> mainFrame.showRequestList());
        viewDonorsButton.addActionListener(e -> mainFrame.showDonorList());
        viewBloodStockButton.addActionListener(e -> mainFrame.showBloodStockList());
        logoutButton.addActionListener(e -> mainFrame.showLogin());
        analyticsDashboardButton.addActionListener(e -> mainFrame.showAnalyticsDashboard());
    }
}
