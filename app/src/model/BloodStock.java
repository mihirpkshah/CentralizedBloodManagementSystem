package model;

import java.sql.Date;

public class BloodStock {
    private int stockId;
    private int bankId;
    private String bloodGroup;
    private int quantity;
    private Date expiryDate;

    public BloodStock(int stockId, int bankId, String bloodGroup, int quantity, Date expiryDate) {
        this.stockId = stockId;
        this.bankId = bankId;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getters and setters
    public int getStockId() { return stockId; }
    public void setStockId(int stockId) { this.stockId = stockId; }
    public int getBankId() { return bankId; }
    public void setBankId(int bankId) { this.bankId = bankId; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
}