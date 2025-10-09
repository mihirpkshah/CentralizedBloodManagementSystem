-- USERS
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('donor', 'hospital', 'blood_bank', 'standby_donor', 'admin') NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255)
);

INSERT INTO users (name, email, password_hash, role, phone, address) VALUES
('Alice Donor', 'alice@example.com', 'hash1', 'donor', '1234567890', '123 Main St'),
('Bob Bank', 'bob@example.com', 'hash2', 'blood_bank', '2345678901', '456 Bank Rd'),
('Carol Hospital', 'carol@example.com', 'hash3', 'hospital', '3456789012', '789 Hospital Ave'),
('Dave Admin', 'dave@example.com', 'hash4', 'admin', '4567890123', 'Admin HQ');

-- BLOOD_BANKS
CREATE TABLE blood_banks (
    bank_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    contact VARCHAR(50),
    opening_hours VARCHAR(50),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO blood_banks (name, location, contact, opening_hours, user_id) VALUES
('Central Blood Bank', 'City Center', '111-222-3333', '9am-5pm', 2);

-- BLOOD_STOCK
CREATE TABLE blood_stock (
    stock_id INT AUTO_INCREMENT PRIMARY KEY,
    bank_id INT,
    blood_group VARCHAR(5),
    quantity INT,
    expiry_date DATE,
    FOREIGN KEY (bank_id) REFERENCES blood_banks(bank_id)
);

INSERT INTO blood_stock (bank_id, blood_group, quantity, expiry_date) VALUES
(1, 'A+', 10, '2025-12-31'),
(1, 'O-', 5, '2025-11-30');

-- BLOOD_CAMPS
CREATE TABLE blood_camps (
    camp_id INT AUTO_INCREMENT PRIMARY KEY,
    bank_id INT,
    venue VARCHAR(100),
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (bank_id) REFERENCES blood_banks(bank_id)
);

INSERT INTO blood_camps (bank_id, venue, start_date, end_date) VALUES
(1, 'Community Hall', '2025-10-15', '2025-10-15');

-- DONORS
CREATE TABLE donors (
    donor_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    blood_group VARCHAR(5),
    standby_available BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO donors (user_id, blood_group, standby_available) VALUES
(1, 'A+', TRUE);

-- DONATIONS
CREATE TABLE donations (
    donation_id INT AUTO_INCREMENT PRIMARY KEY,
    donor_id INT,
    camp_id INT,
    bank_id INT,
    donation_date DATE,
    units_donated INT,
    FOREIGN KEY (donor_id) REFERENCES donors(donor_id),
    FOREIGN KEY (camp_id) REFERENCES blood_camps(camp_id),
    FOREIGN KEY (bank_id) REFERENCES blood_banks(bank_id)
);

INSERT INTO donations (donor_id, camp_id, bank_id, donation_date, units_donated) VALUES
(1, 1, 1, '2025-10-15', 1);

-- HOSPITALS
CREATE TABLE hospitals (
    hospital_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    name VARCHAR(100),
    location VARCHAR(100),
    contact VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO hospitals (user_id, name, location, contact) VALUES
(3, 'City Hospital', 'Downtown', '555-1234');

-- REQUESTS
CREATE TABLE requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    hospital_id INT,
    bank_id INT,
    blood_group VARCHAR(5),
    units_requested INT,
    request_date DATE,
    status ENUM('pending', 'approved', 'rejected', 'fulfilled'),
    FOREIGN KEY (hospital_id) REFERENCES hospitals(hospital_id),
    FOREIGN KEY (bank_id) REFERENCES blood_banks(bank_id)
);

INSERT INTO requests (hospital_id, bank_id, blood_group, units_requested, request_date, status) VALUES
(1, 1, 'A+', 2, '2025-10-10', 'pending');

-- STANDBY_CONTACTS
CREATE TABLE standby_contacts (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    donor_id INT,
    hospital_id INT,
    request_date DATE,
    status ENUM('pending', 'approved', 'rejected', 'fulfilled'),
    FOREIGN KEY (donor_id) REFERENCES donors(donor_id),
    FOREIGN KEY (hospital_id) REFERENCES hospitals(hospital_id)
);

INSERT INTO standby_contacts (donor_id, hospital_id, request_date, status) VALUES
(1, 1, '2025-10-10', 'pending');

-- REPORTS
CREATE TABLE reports (
    report_id INT AUTO_INCREMENT PRIMARY KEY,
    bank_id INT,
    report_date DATE,
    report_type VARCHAR(50),
    details TEXT,
    FOREIGN KEY (bank_id) REFERENCES blood_banks(bank_id)
);

INSERT INTO reports (bank_id, report_date, report_type, details) VALUES
(1, '2025-10-01', 'Monthly', 'Monthly report details here.');

