package service;

import dao.BloodStockDAO;
import dao.DonorDAO;
import dao.HospitalDAO;
import dao.RequestDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsService {
    private RequestDAO requestDAO = new RequestDAO();
    private BloodStockDAO bloodStockDAO = new BloodStockDAO();
    private DonorDAO donorDAO = new DonorDAO();
    private HospitalDAO hospitalDAO = new HospitalDAO();

    public Map<String, Integer> getRequestStats() {
        Map<String, Integer> stats = new HashMap<>();
        try (Connection conn = util.DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT status, COUNT(*) as cnt FROM requests GROUP BY status")) {
            while (rs.next()) {
                stats.put(rs.getString("status"), rs.getInt("cnt"));
            }
        } catch (SQLException e) {
            // handle error
        }
        return stats;
    }

    public Map<String, Integer> getBloodStockStats() {
        Map<String, Integer> stats = new HashMap<>();
        try (Connection conn = util.DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT blood_group, SUM(quantity) as qty FROM blood_stock GROUP BY blood_group")) {
            while (rs.next()) {
                stats.put(rs.getString("blood_group"), rs.getInt("qty"));
            }
        } catch (SQLException e) {
            // handle error
        }
        return stats;
    }

    public int getDonorCount() {
        try (Connection conn = util.DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM donors")) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {}
        return 0;
    }

    public int getHospitalCount() {
        try (Connection conn = util.DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM hospitals")) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {}
        return 0;
    }
}

