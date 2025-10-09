package dao;

import model.BloodBank;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodBankDAO {
    public void addBloodBank(BloodBank bank) throws SQLException {
        String sql = "INSERT INTO blood_banks (name, location, contact, opening_hours, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bank.getName());
            stmt.setString(2, bank.getLocation());
            stmt.setString(3, bank.getContact());
            stmt.setString(4, bank.getOpeningHours());
            stmt.setInt(5, bank.getUserId());
            stmt.executeUpdate();
        }
    }

    public BloodBank getBloodBankById(int bankId) throws SQLException {
        String sql = "SELECT * FROM blood_banks WHERE bank_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bankId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BloodBank(
                    rs.getInt("bank_id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("contact"),
                    rs.getString("opening_hours"),
                    rs.getInt("user_id")
                );
            }
        }
        return null;
    }

    public List<BloodBank> getAllBloodBanks() throws SQLException {
        List<BloodBank> banks = new ArrayList<>();
        String sql = "SELECT * FROM blood_banks";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                banks.add(new BloodBank(
                    rs.getInt("bank_id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("contact"),
                    rs.getString("opening_hours"),
                    rs.getInt("user_id")
                ));
            }
        }
        return banks;
    }
}

