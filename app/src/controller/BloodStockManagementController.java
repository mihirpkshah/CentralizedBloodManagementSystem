package controller;

import model.BloodStock;
import service.BloodStockService;
import view.BloodStockManagementPanel;
import java.sql.Date;
import java.sql.SQLException;

public class BloodStockManagementController {
    private BloodStockService bloodStockService;
    private BloodStockManagementPanel panel;

    public BloodStockManagementController(BloodStockManagementPanel panel) {
        this.panel = panel;
        this.bloodStockService = new BloodStockService();
    }

    public void handleAddStock() {
        try {
            int bankId = panel.getBankId();
            String bloodGroup = panel.getBloodGroup();
            int quantity = panel.getQuantity();
            String expiryDateStr = panel.getExpiryDate();
            if (bloodGroup.isEmpty() || expiryDateStr.isEmpty()) {
                panel.setStatus("All fields are required.");
                return;
            }
            Date expiryDate = Date.valueOf(expiryDateStr);
            BloodStock stock = new BloodStock(0, bankId, bloodGroup, quantity, expiryDate);
            bloodStockService.addBloodStock(stock);
            panel.setStatus("Blood stock added successfully.");
            panel.clearForm();
        } catch (NumberFormatException e) {
            panel.setStatus("Invalid number format.");
        } catch (IllegalArgumentException e) {
            panel.setStatus("Invalid date format. Use yyyy-mm-dd.");
        } catch (SQLException e) {
            panel.setStatus("Database error.");
        }
    }
}

