package controller;

import model.Donor;
import service.DonorService;
import view.DonorRegistrationPanel;
import javax.swing.*;
import java.sql.SQLException;

public class DonorRegistrationController {
    private DonorService donorService;
    private DonorRegistrationPanel panel;

    public DonorRegistrationController(DonorRegistrationPanel panel) {
        this.panel = panel;
        this.donorService = new DonorService();
    }

    public void handleRegister() {
        try {
            int userId = panel.getUserId();
            String bloodGroup = panel.getBloodGroup();
            boolean standby = panel.isStandbyAvailable();
            if (bloodGroup.isEmpty()) {
                panel.setStatus("Blood group is required.");
                return;
            }
            Donor donor = new Donor(0, userId, bloodGroup, standby);
            donorService.addDonor(donor);
            panel.setStatus("Donor registered successfully.");
            panel.clearForm();
        } catch (NumberFormatException e) {
            panel.setStatus("Invalid user ID.");
        } catch (SQLException e) {
            panel.setStatus("Database error.");
        }
    }
}

