package model;

public class Donor {
    private int donorId;
    private int userId;
    private String bloodGroup;
    private boolean standbyAvailable;

    public Donor(int donorId, int userId, String bloodGroup, boolean standbyAvailable) {
        this.donorId = donorId;
        this.userId = userId;
        this.bloodGroup = bloodGroup;
        this.standbyAvailable = standbyAvailable;
    }

    // Getters and setters
    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public boolean isStandbyAvailable() { return standbyAvailable; }
    public void setStandbyAvailable(boolean standbyAvailable) { this.standbyAvailable = standbyAvailable; }
}

