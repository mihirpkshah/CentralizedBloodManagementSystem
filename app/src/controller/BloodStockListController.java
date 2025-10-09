package controller;

import model.BloodStock;
import service.BloodStockService;
import view.BloodStockListPanel;
import java.sql.SQLException;
import java.util.List;

public class BloodStockListController {
    private BloodStockService bloodStockService;
    private BloodStockListPanel panel;

    public BloodStockListController(BloodStockListPanel panel) {
        this.panel = panel;
        this.bloodStockService = new BloodStockService();
    }

    public void loadBloodStock() {
        try {
            List<BloodStock> stocks = bloodStockService.getAllBloodStock();
            panel.setBloodStock(stocks);
            panel.setStatus("Loaded " + stocks.size() + " blood stock records.");
        } catch (SQLException e) {
            panel.setStatus("Database error loading blood stock.");
        }
    }
}

