package service;

import dao.HospitalDAO;
import model.Hospital;
import java.sql.SQLException;
import java.util.List;

public class HospitalService {
    private HospitalDAO hospitalDAO;

    public HospitalService() {
        this.hospitalDAO = new HospitalDAO();
    }

    public void addHospital(Hospital hospital) throws SQLException {
        hospitalDAO.addHospital(hospital);
    }

    public Hospital getHospitalById(int hospitalId) throws SQLException {
        return hospitalDAO.getHospitalById(hospitalId);
    }

    public List<Hospital> getAllHospitals() throws SQLException {
        return hospitalDAO.getAllHospitals();
    }
}

