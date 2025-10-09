package service;

import dao.RequestDAO;
import model.Request;
import java.sql.SQLException;
import java.util.List;

public class RequestService {
    private RequestDAO requestDAO;

    public RequestService() {
        this.requestDAO = new RequestDAO();
    }

    public void addRequest(Request request) throws SQLException {
        requestDAO.addRequest(request);
    }

    public List<Request> getAllRequests() throws SQLException {
        return requestDAO.getAllRequests();
    }

    public List<Request> getFilteredRequests(Integer hospitalId, Integer bankId, String status) throws SQLException {
        return requestDAO.getFilteredRequests(hospitalId, bankId, status);
    }

    public void updateRequestStatus(int requestId, String status) throws SQLException {
        requestDAO.updateRequestStatus(requestId, status);
    }
}
