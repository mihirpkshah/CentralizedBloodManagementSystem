package dao;

import model.Donor;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {
    public void addDonor(Donor donor) throws SQLException {
        String sql = "INSERT INTO donors (user_id, blood_group, standby_available) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, donor.getUserId());
            stmt.setString(2, donor.getBloodGroup());
            stmt.setBoolean(3, donor.isStandbyAvailable());
            stmt.executeUpdate();
        }
    }

    public Donor getDonorById(int donorId) throws SQLException {
        String sql = "SELECT * FROM donors WHERE donor_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, donorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Donor(
                    rs.getInt("donor_id"),
                    rs.getInt("user_id"),
                    rs.getString("blood_group"),
                    rs.getBoolean("standby_available")
                );
            }
        }
        return null;
    }

    public List<Donor> getAllDonors() throws SQLException {
        List<Donor> donors = new ArrayList<>();
        String sql = "SELECT * FROM donors";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                donors.add(new Donor(
                    rs.getInt("donor_id"),
                    rs.getInt("user_id"),
                    rs.getString("blood_group"),
                    rs.getBoolean("standby_available")
                ));
            }
        }
        return donors;
    }
}