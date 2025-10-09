package dao;

import model.Request;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    public void addRequest(Request request) throws SQLException {
        String sql = "INSERT INTO requests (hospital_id, bank_id, blood_group, units_requested, request_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, request.getHospitalId());
            stmt.setInt(2, request.getBankId());
            stmt.setString(3, request.getBloodGroup());
            stmt.setInt(4, request.getUnitsRequested());
            stmt.setDate(5, request.getRequestDate());
            stmt.setString(6, request.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Request> getAllRequests() throws SQLException {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                requests.add(new Request(
                    rs.getInt("request_id"),
                    rs.getInt("hospital_id"),
                    rs.getInt("bank_id"),
                    rs.getString("blood_group"),
                    rs.getInt("units_requested"),
                    rs.getDate("request_date"),
                    rs.getString("status")
                ));
            }
        }
        return requests;
    }

    public List<Request> getFilteredRequests(Integer hospitalId, Integer bankId, String status) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM requests WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (hospitalId != null) {
            sql.append(" AND hospital_id = ?");
            params.add(hospitalId);
        }
        if (bankId != null) {
            sql.append(" AND bank_id = ?");
            params.add(bankId);
        }
        if (status != null && !status.isEmpty()) {
            sql.append(" AND status = ?");
            params.add(status);
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            ResultSet rs = stmt.executeQuery();
            List<Request> requests = new ArrayList<>();
            while (rs.next()) {
                requests.add(new Request(
                    rs.getInt("request_id"),
                    rs.getInt("hospital_id"),
                    rs.getInt("bank_id"),
                    rs.getString("blood_group"),
                    rs.getInt("units_requested"),
                    rs.getDate("request_date"),
                    rs.getString("status")
                ));
            }
            return requests;
        }
    }

    public void updateRequestStatus(int requestId, String status) throws SQLException {
        String sql = "UPDATE requests SET status = ? WHERE request_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, requestId);
            stmt.executeUpdate();
        }
    }
}
