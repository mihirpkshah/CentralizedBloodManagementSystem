package controller;

import model.Request;
import service.RequestService;
import service.NotificationService;
import view.HospitalRequestPanel;

import java.sql.Date;

public class HospitalRequestController {
    private HospitalRequestPanel panel;
    private RequestService requestService;

    public HospitalRequestController(HospitalRequestPanel panel) {
        this.panel = panel;
        this.requestService = new RequestService();
    }

    public void handleRequest() {
        try {
            int hospitalId = panel.getHospitalId();
            String bloodGroup = panel.getBloodGroup();
            int quantity = panel.getQuantity();
            if (bloodGroup.isEmpty()) {
                panel.setStatus("Blood group is required.");
                return;
            }
            // For demo, assign bankId=1 and status="pending". In production, select bankId based on logic.
            int bankId = 1;
            Date requestDate = new Date(System.currentTimeMillis());
            String status = "pending";
            Request request = new Request(0, hospitalId, bankId, bloodGroup, quantity, requestDate, status);
            requestService.addRequest(request);
            NotificationService.getInstance().notifyUser("Your blood request has been submitted and is pending.");
            panel.setStatus("Blood request submitted.");
            panel.clearForm();
        } catch (NumberFormatException e) {
            panel.setStatus("Invalid input.");
        } catch (Exception e) {
            panel.setStatus("Database error.");
        }
    }
}
