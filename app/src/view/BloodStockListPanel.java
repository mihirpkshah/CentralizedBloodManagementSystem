package view;

import controller.BloodStockListController;
import model.BloodStock;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BloodStockListPanel extends JPanel {
    private JTable stockTable;
    private DefaultTableModel tableModel;
    private BloodStockListController controller;
    private JButton refreshButton;
    private JLabel statusLabel;
    private JButton backButton;

    public BloodStockListPanel(MainFrame mainFrame) {
        this.controller = new BloodStockListController(this);
        setLayout(new BorderLayout());
        String[] columns = {"Stock ID", "Bank ID", "Blood Group", "Quantity", "Expiry Date"};
        tableModel = new DefaultTableModel(columns, 0);
        stockTable = new JTable(tableModel);
        add(new JScrollPane(stockTable), BorderLayout.CENTER);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        refreshButton = new JButton("Refresh");
        statusLabel = new JLabel("");
        topPanel.add(refreshButton);
        topPanel.add(statusLabel);
        add(topPanel, BorderLayout.NORTH);
        refreshButton.addActionListener(e -> controller.loadBloodStock());
        controller.loadBloodStock();
        backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    public void setBloodStock(List<BloodStock> stocks) {
        tableModel.setRowCount(0);
        for (BloodStock s : stocks) {
            tableModel.addRow(new Object[]{
                s.getStockId(),
                s.getBankId(),
                s.getBloodGroup(),
                s.getQuantity(),
                s.getExpiryDate()
            });
        }
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
