package dao;

import model.BloodStock;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodStockDAO {
    public void addBloodStock(BloodStock stock) throws SQLException {
        String sql = "INSERT INTO blood_stock (bank_id, blood_group, quantity, expiry_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stock.getBankId());
            stmt.setString(2, stock.getBloodGroup());
            stmt.setInt(3, stock.getQuantity());
            stmt.setDate(4, stock.getExpiryDate());
            stmt.executeUpdate();
        }
    }

    public BloodStock getBloodStockById(int stockId) throws SQLException {
        String sql = "SELECT * FROM blood_stock WHERE stock_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stockId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BloodStock(
                    rs.getInt("stock_id"),
                    rs.getInt("bank_id"),
                    rs.getString("blood_group"),
                    rs.getInt("quantity"),
                    rs.getDate("expiry_date")
                );
            }
        }
        return null;
    }

    public List<BloodStock> getAllBloodStock() throws SQLException {
        List<BloodStock> stocks = new ArrayList<>();
        String sql = "SELECT * FROM blood_stock";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                stocks.add(new BloodStock(
                    rs.getInt("stock_id"),
                    rs.getInt("bank_id"),
                    rs.getString("blood_group"),
                    rs.getInt("quantity"),
                    rs.getDate("expiry_date")
                ));
            }
        }
        return stocks;
    }
}

