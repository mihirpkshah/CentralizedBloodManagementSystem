package view;

import controller.RequestListController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RequestListPanel extends JPanel {
    private JTextField hospitalIdField;
    private JTextField bankIdField;
    private JComboBox<String> statusCombo;
    private RequestListController controller;
    private JTable requestTable;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private JLabel statusLabel;
    private JButton backButton;
    private MainFrame mainFrame;

    public RequestListPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.controller = new RequestListController(this);
        setLayout(new BorderLayout());

        String[] columns = {"Request ID", "Hospital ID", "Bank ID", "Blood Group", "Units", "Date", "Status", "Actions"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // Only the Actions column is editable
            }
        };
        requestTable = new JTable(tableModel);
        requestTable.getColumn("Actions").setCellRenderer(new ButtonRenderer());
        requestTable.getColumn("Actions").setCellEditor(new ButtonEditor(new JCheckBox(), controller));
        add(new JScrollPane(requestTable), BorderLayout.CENTER);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.add(new JLabel("Hospital ID:"));
        hospitalIdField = new JTextField(5);
        filterPanel.add(hospitalIdField);
        filterPanel.add(new JLabel("Bank ID:"));
        bankIdField = new JTextField(5);
        filterPanel.add(bankIdField);
        filterPanel.add(new JLabel("Status:"));
        statusCombo = new JComboBox<>(new String[]{"", "pending", "approved", "rejected", "fulfilled"});
        filterPanel.add(statusCombo);
        JButton filterButton = new JButton("Filter");
        filterPanel.add(filterButton);
        add(filterPanel, BorderLayout.SOUTH);
        filterButton.addActionListener(e -> controller.loadRequestsWithFilter());

        JPanel topPanel = new JPanel(new BorderLayout());
        refreshButton = new JButton("Refresh");
        topPanel.add(refreshButton, BorderLayout.EAST);
        statusLabel = new JLabel(" ");
        topPanel.add(statusLabel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        refreshButton.addActionListener(e -> controller.refreshRequests());

        backButton = new JButton("Back");
        add(backButton, BorderLayout.PAGE_END);
        backButton.addActionListener(e -> mainFrame.showDashboard());

        controller.loadRequests();
    }

    public Integer getHospitalIdFilter() {
        String val = hospitalIdField.getText();
        return val.isEmpty() ? null : Integer.parseInt(val);
    }

    public Integer getBankIdFilter() {
        String val = bankIdField.getText();
        return val.isEmpty() ? null : Integer.parseInt(val);
    }

    public String getStatusFilter() {
        return (String) statusCombo.getSelectedItem();
    }

    public int getRequestIdAtRow(int row) {
        return (int) tableModel.getValueAt(row, 0);
    }

    // Set the requests in the table
    public void setRequests(List<model.Request> requests) {
        tableModel.setRowCount(0);
        for (model.Request r : requests) {
            tableModel.addRow(new Object[]{
                r.getRequestId(),
                r.getHospitalId(),
                r.getBankId(),
                r.getBloodGroup(),
                r.getUnitsRequested(),
                r.getRequestDate(),
                r.getStatus(),
                null // Placeholder for actions column
            });
        }
    }

    // Set the status message
    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    // ButtonRenderer and ButtonEditor classes for action buttons
    class ButtonRenderer extends JPanel implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));
            add(new JButton("Approve"));
            add(new JButton("Reject"));
            add(new JButton("Fulfill"));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JPanel panel;
        private JButton approveBtn, rejectBtn, fulfillBtn;
        private int row;
        private RequestListController controller;

        public ButtonEditor(JCheckBox checkBox, RequestListController controller) {
            super(checkBox);
            this.controller = controller;
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 0));
            approveBtn = new JButton("Approve");
            rejectBtn = new JButton("Reject");
            fulfillBtn = new JButton("Fulfill");
            panel.add(approveBtn);
            panel.add(rejectBtn);
            panel.add(fulfillBtn);
            approveBtn.addActionListener(e -> controller.updateStatus(row, "approved"));
            rejectBtn.addActionListener(e -> controller.updateStatus(row, "rejected"));
            fulfillBtn.addActionListener(e -> controller.updateStatus(row, "fulfilled"));
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }
    }
}
