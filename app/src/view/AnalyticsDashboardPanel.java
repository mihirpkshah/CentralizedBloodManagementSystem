package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import service.AnalyticsService;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AnalyticsDashboardPanel extends JPanel {
    private JLabel requestsLabel;
    private JLabel bloodStockLabel;
    private JLabel donorLabel;
    private JLabel hospitalLabel;
    private ChartPanel requestPieChartPanel;
    private ChartPanel bloodStockBarChartPanel;
    private AnalyticsService analyticsService;

    public AnalyticsDashboardPanel(AnalyticsService analyticsService, MainFrame mainFrame) {
        this.analyticsService = analyticsService;
        setLayout(new GridLayout(3, 2));

        requestsLabel = new JLabel();
        bloodStockLabel = new JLabel();
        donorLabel = new JLabel();
        hospitalLabel = new JLabel();
        requestPieChartPanel = new ChartPanel(null);
        bloodStockBarChartPanel = new ChartPanel(null);

        add(requestsLabel);
        add(bloodStockLabel);
        add(donorLabel);
        add(hospitalLabel);
        add(requestPieChartPanel);
        add(bloodStockBarChartPanel);

        loadStats();

        JButton backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> mainFrame.showDashboard());
    }

    private void loadStats() {
        Map<String, Integer> reqStats = analyticsService.getRequestStats();
        requestsLabel.setText("Requests: " + reqStats);
        Map<String, Integer> stockStats = analyticsService.getBloodStockStats();
        bloodStockLabel.setText("Blood Stock: " + stockStats);
        donorLabel.setText("Total Donors: " + analyticsService.getDonorCount());
        hospitalLabel.setText("Total Hospitals: " + analyticsService.getHospitalCount());
        // Pie chart for requests by status
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : reqStats.entrySet()) {
            pieDataset.setValue(entry.getKey(), entry.getValue());
        }
        JFreeChart pieChart = ChartFactory.createPieChart("Requests by Status", pieDataset, true, true, false);
        requestPieChartPanel.setChart(pieChart);
        // Bar chart for blood stock by group
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : stockStats.entrySet()) {
            barDataset.addValue(entry.getValue(), "Units", entry.getKey());
        }
        JFreeChart barChart = ChartFactory.createBarChart("Blood Stock by Group", "Blood Group", "Units", barDataset);
        bloodStockBarChartPanel.setChart(barChart);
    }
}
