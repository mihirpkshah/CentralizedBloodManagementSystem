package service;

import dao.BloodBankDAO;
import model.BloodBank;
import java.sql.SQLException;
import java.util.List;

public class BloodBankService {
    private BloodBankDAO bloodBankDAO;

    public BloodBankService() {
        this.bloodBankDAO = new BloodBankDAO();
    }

    public void addBloodBank(BloodBank bank) throws SQLException {
        bloodBankDAO.addBloodBank(bank);
    }

    public BloodBank getBloodBankById(int bankId) throws SQLException {
        return bloodBankDAO.getBloodBankById(bankId);
    }

    public List<BloodBank> getAllBloodBanks() throws SQLException {
        return bloodBankDAO.getAllBloodBanks();
    }
}

