package model;

public class Hospital {
    private int hospitalId;
    private int userId;
    private String name;
    private String location;
    private String contact;

    public Hospital(int hospitalId, int userId, String name, String location, String contact) {
        this.hospitalId = hospitalId;
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    // Getters and setters
    public int getHospitalId() { return hospitalId; }
    public void setHospitalId(int hospitalId) { this.hospitalId = hospitalId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}

