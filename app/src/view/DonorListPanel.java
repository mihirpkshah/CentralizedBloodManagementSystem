package view;

import controller.DonorListController;
import model.Donor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DonorListPanel extends JPanel {
    private JTable donorTable;
    private DefaultTableModel tableModel;
    private DonorListController controller;
    private JButton refreshButton;
    private JLabel statusLabel;
    private JButton backButton;

    public DonorListPanel(MainFrame mainFrame) {
        this.controller = new DonorListController(this);
        setLayout(new BorderLayout());
        String[] columns = {"Donor ID", "User ID", "Blood Group", "Standby Available"};
        tableModel = new DefaultTableModel(columns, 0);
        donorTable = new JTable(tableModel);
        add(new JScrollPane(donorTable), BorderLayout.CENTER);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        refreshButton = new JButton("Refresh");
        statusLabel = new JLabel("");
        topPanel.add(refreshButton);
        topPanel.add(statusLabel);
        add(topPanel, BorderLayout.NORTH);
        refreshButton.addActionListener(e -> controller.loadDonors());
        controller.loadDonors();
        backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public void setDonors(List<Donor> donors) {
        tableModel.setRowCount(0);
        for (Donor d : donors) {
            tableModel.addRow(new Object[]{
                d.getDonorId(),
                d.getUserId(),
                d.getBloodGroup(),
                d.isStandbyAvailable()
            });
        }
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
