
package model;

public class BloodBank {
    private int bankId;
    private String name;
    private String location;
    private String contact;
    private String openingHours;
    private int userId;

    public BloodBank(int bankId, String name, String location, String contact, String openingHours, int userId) {
        this.bankId = bankId;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.openingHours = openingHours;
        this.userId = userId;
    }

    // Getters and setters
    public int getBankId() { return bankId; }
    public void setBankId(int bankId) { this.bankId = bankId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getOpeningHours() { return openingHours; }
    public void setOpeningHours(String openingHours) { this.openingHours = openingHours; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}

