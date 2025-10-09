package service;

import dao.BloodStockDAO;
import model.BloodStock;
import java.sql.SQLException;
import java.util.List;

public class BloodStockService {
    private BloodStockDAO bloodStockDAO;

    public BloodStockService() {
        this.bloodStockDAO = new BloodStockDAO();
    }

    public void addBloodStock(BloodStock stock) throws SQLException {
        bloodStockDAO.addBloodStock(stock);
    }

    public List<BloodStock> getAllBloodStock() throws SQLException {
        return bloodStockDAO.getAllBloodStock();
    }
}

