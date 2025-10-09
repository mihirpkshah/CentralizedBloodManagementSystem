package view;

import service.AnalyticsService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LoginPanel loginPanel;
    private DashboardPanel dashboardPanel;
    private DonorRegistrationPanel donorRegistrationPanel;
    private BloodStockManagementPanel bloodStockManagementPanel;
    private HospitalRequestPanel hospitalRequestPanel;
    private UserRegistrationPanel userRegistrationPanel;
    private RequestListPanel requestListPanel;
    private DonorListPanel donorListPanel;
    private BloodStockListPanel bloodStockListPanel;
    private AnalyticsDashboardPanel analyticsDashboardPanel;

    public MainFrame() {
        setTitle("Centralized Blood Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPanel = new LoginPanel(this);
        dashboardPanel = new DashboardPanel(this);
        donorRegistrationPanel = new DonorRegistrationPanel(this);
        bloodStockManagementPanel = new BloodStockManagementPanel(this);
        hospitalRequestPanel = new HospitalRequestPanel(this);
        userRegistrationPanel = new UserRegistrationPanel(this);
        requestListPanel = new RequestListPanel(this);
        donorListPanel = new DonorListPanel(this);
        bloodStockListPanel = new BloodStockListPanel(this);
        analyticsDashboardPanel = new AnalyticsDashboardPanel(new AnalyticsService(), this);

        mainPanel.add(loginPanel, "login");
        mainPanel.add(dashboardPanel, "dashboard");
        mainPanel.add(donorRegistrationPanel, "donorRegistration");
        mainPanel.add(bloodStockManagementPanel, "bloodStockManagement");
        mainPanel.add(hospitalRequestPanel, "hospitalRequest");
        mainPanel.add(userRegistrationPanel, "userRegistration");
        mainPanel.add(requestListPanel, "requestList");
        mainPanel.add(donorListPanel, "donorList");
        mainPanel.add(bloodStockListPanel, "bloodStockList");
        mainPanel.add(analyticsDashboardPanel, "analyticsDashboard");

        add(mainPanel);
        showLogin();
    }

    public void showLogin() {
        cardLayout.show(mainPanel, "login");
    }

    public void showDashboard() {
        cardLayout.show(mainPanel, "dashboard");
    }

    public void showDonorRegistration() {
        cardLayout.show(mainPanel, "donorRegistration");
    }

    public void showBloodStockManagement() {
        cardLayout.show(mainPanel, "bloodStockManagement");
    }

    public void showHospitalRequest() {
        cardLayout.show(mainPanel, "hospitalRequest");
    }

    public void showUserRegistration() {
        cardLayout.show(mainPanel, "userRegistration");
    }

    public void showRequestList() {
        cardLayout.show(mainPanel, "requestList");
    }

    public void showDonorList() {
        cardLayout.show(mainPanel, "donorList");
    }

    public void showBloodStockList() {
        cardLayout.show(mainPanel, "bloodStockList");
    }

    public void showAnalyticsDashboard() {
        cardLayout.show(mainPanel, "analyticsDashboard");
    }
}
