package dao;

import model.Hospital;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
    public void addHospital(Hospital hospital) throws SQLException {
        String sql = "INSERT INTO hospitals (user_id, name, location, contact) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hospital.getUserId());
            stmt.setString(2, hospital.getName());
            stmt.setString(3, hospital.getLocation());
            stmt.setString(4, hospital.getContact());
            stmt.executeUpdate();
        }
    }

    public Hospital getHospitalById(int hospitalId) throws SQLException {
        String sql = "SELECT * FROM hospitals WHERE hospital_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hospitalId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Hospital(
                    rs.getInt("hospital_id"),
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("contact")
                );
            }
        }
        return null;
    }

    public List<Hospital> getAllHospitals() throws SQLException {
        List<Hospital> hospitals = new ArrayList<>();
        String sql = "SELECT * FROM hospitals";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hospitals.add(new Hospital(
                    rs.getInt("hospital_id"),
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("location"),
                    rs.getString("contact")
                ));
            }
        }
        return hospitals;
    }
}

