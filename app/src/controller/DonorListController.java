package controller;

import model.Donor;
import service.DonorService;
import view.DonorListPanel;
import java.sql.SQLException;
import java.util.List;

public class DonorListController {
    private DonorService donorService;
    private DonorListPanel panel;

    public DonorListController(DonorListPanel panel) {
        this.panel = panel;
        this.donorService = new DonorService();
    }

    public void loadDonors() {
        try {
            List<Donor> donors = donorService.getAllDonors();
            panel.setDonors(donors);
            panel.setStatus("Loaded " + donors.size() + " donors.");
        } catch (SQLException e) {
            panel.setStatus("Database error loading donors.");
        }
    }
}

