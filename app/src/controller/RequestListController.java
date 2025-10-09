package controller;

import model.Request;
import service.RequestService;
import service.NotificationService;
import view.RequestListPanel;
import java.sql.SQLException;
import java.util.List;

public class RequestListController {
    private final RequestService requestService;
    private final RequestListPanel panel;

    public RequestListController(RequestListPanel panel) {
        this.panel = panel;
        this.requestService = new RequestService();
    }

    // Load all requests
    public void loadRequests() {
        try {
            List<Request> requests = requestService.getAllRequests();
            panel.setRequests(requests);
            panel.setStatus("Loaded " + requests.size() + " requests.");
        } catch (SQLException e) {
            panel.setStatus("Database error loading requests.");
            // Optionally log e.printStackTrace();
        }
    }

    // Load requests with filters
    public void loadRequestsWithFilter() {
        try {
            Integer hospitalId = panel.getHospitalIdFilter();
            Integer bankId = panel.getBankIdFilter();
            String status = panel.getStatusFilter();
            List<Request> requests = requestService.getFilteredRequests(hospitalId, bankId, status);
            panel.setRequests(requests);
            panel.setStatus("Loaded " + requests.size() + " filtered requests.");
        } catch (SQLException e) {
            panel.setStatus("Database error loading filtered requests.");
            // Optionally log e.printStackTrace();
        }
    }

    // Update the status of a request
    public void updateStatus(int row, String status) {
        try {
            int requestId = panel.getRequestIdAtRow(row);
            requestService.updateRequestStatus(requestId, status);
            if ("fulfilled".equals(status)) {
                NotificationService.getInstance().notifyUser("Request " + requestId + " has been fulfilled.");
            }
            loadRequests();
            panel.setStatus("Request " + requestId + " updated to " + status + ".");
        } catch (SQLException e) {
            panel.setStatus("Database error updating request status.");
            // Optionally log e.printStackTrace();
        }
    }

    // Refresh the requests list
    public void refreshRequests() {
        loadRequests();
    }
}
