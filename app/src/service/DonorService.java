package service;

import dao.DonorDAO;
import model.Donor;
import java.sql.SQLException;
import java.util.List;

public class DonorService {
    private DonorDAO donorDAO;

    public DonorService() {
        this.donorDAO = new DonorDAO();
    }

    public void addDonor(Donor donor) throws SQLException {
        donorDAO.addDonor(donor);
    }

    public Donor getDonorById(int donorId) throws SQLException {
        return donorDAO.getDonorById(donorId);
    }

    public List<Donor> getAllDonors() throws SQLException {
        return donorDAO.getAllDonors();
    }
}

