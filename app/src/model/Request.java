package model;

import java.sql.Date;

public class Request {
    private int requestId;
    private int hospitalId;
    private int bankId;
    private String bloodGroup;
    private int unitsRequested;
    private Date requestDate;
    private String status;

    public Request(int requestId, int hospitalId, int bankId, String bloodGroup, int unitsRequested, Date requestDate, String status) {
        this.requestId = requestId;
        this.hospitalId = hospitalId;
        this.bankId = bankId;
        this.bloodGroup = bloodGroup;
        this.unitsRequested = unitsRequested;
        this.requestDate = requestDate;
        this.status = status;
    }

    // Getters and setters
    public int getRequestId() { return requestId; }
    public void setRequestId(int requestId) { this.requestId = requestId; }
    public int getHospitalId() { return hospitalId; }
    public void setHospitalId(int hospitalId) { this.hospitalId = hospitalId; }
    public int getBankId() { return bankId; }
    public void setBankId(int bankId) { this.bankId = bankId; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public int getUnitsRequested() { return unitsRequested; }
    public void setUnitsRequested(int unitsRequested) { this.unitsRequested = unitsRequested; }
    public Date getRequestDate() { return requestDate; }
    public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

