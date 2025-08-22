# Software Requirement Specification

---

## **1. Introduction**

### 1.1 Purpose

The purpose of this document is to define the requirements for the **Blood Bank Management System (BBMS)**, a web-based platform that streamlines blood donation, storage, and distribution. The system will serve **blood banks, donors, hospitals, and recipients**, providing real-time blood availability, donor support, inventory management, and AI-based predictions.

### 1.2 Scope

The Blood Bank Management System is a **cloud-hosted web application** built using **React (frontend), Node.js/Express (backend), SQL (database), and Google Cloud Platform (infrastructure)**.

Key stakeholders:

- **Donors**: Can register, view donation camps, and volunteer as standby donors.
- **Blood Banks**: Manage blood stock, schedule donation camps, and monitor dashboards.
- **Hospitals/Recipients**: Search, filter, and request blood based on group, location, or urgency.
- **System Admins**: Monitor overall functioning, manage access, and oversee AI predictions.

The system improves efficiency in managing blood supply chains, reduces wastage, and helps plan donation drives proactively.

### 1.3 Definitions, Acronyms, and Abbreviations

- **BBMS** – Blood Bank Management System
- **SQL** – Structured Query Language
- **AI** – Artificial Intelligence
- **GCP** – Google Cloud Platform

### 1.4 References

- IEEE 830–1998 standard for SRS.
- GCP Documentation.
- React, Node.js, Express, and SQL official documentation.

---

## **2. Overall Description**

### 2.1 Product Perspective

The BBMS is an independent web-based solution hosted on **GCP** using:

- **Frontend**: React + Material UI (for responsive UI).
- **Backend**: Node.js + Express (REST APIs).
- **Database**: Cloud SQL (MySQL/PostgreSQL).
- **Cloud Infra**: GCP Compute Engine, App Engine, Cloud Functions (for AI), BigQuery (analytics).

### 2.2 Product Features

1. **Blood Bank Listing & Details** – View available banks, stock, and expiry.
2. **Donor Management** – Registration, donation history, camp schedules.
3. **Blood Bank Portal** – Login, update inventory, list donation camps.
4. **Hospital/Recipient Portal** – Search, filter, and request blood units.
5. **AI Prediction** – Forecast demand and suggest donation drives.
6. **Standby Donor Support** – Urgent contact mechanism with available donors.
7. **Reports & Dashboards** – Stock reports, usage trends, and demand analysis.
8. **Security** – Role-based access, OAuth 2.0 authentication, GDPR-compliant data handling.

### 2.3 User Classes and Characteristics

- **Donors**: Tech-savvy individuals, mobile/desktop users.
- **Blood Bank Staff**: Admins with moderate IT knowledge.
- **Hospitals/Recipients**: Medical professionals requiring real-time access.
- **System Admin**: Technical staff with full control.

### 2.4 Constraints

- System must be **deployed on GCP**.
- Must handle **simultaneous requests** (scalable to ~5000 concurrent users).
- AI predictions must process at least **1 year of historical data**.
- Data must comply with **healthcare privacy regulations** (GDPR/HIPAA).

### 2.5 Assumptions and Dependencies

- Donors and hospitals have internet access.
- Blood banks maintain accurate inventory records.
- SMS/Email APIs will be integrated for communication.

---

## **3. Specific Requirements**

### 3.1 Functional Requirements

### FR1: Blood Bank Management

- FR1.1: Blood banks can **add, update, and delete stock** (blood group, expiry, quantity).
- FR1.2: System will **auto-remove expired units** from listings.

### FR2: Donor Management

- FR2.1: Donors can **register/login** using email, phone, or social login.
- FR2.2: Donors can **view upcoming camps** with date, venue, and timings.
- FR2.3: Standby donors can opt-in to receive **urgent requests**.

### FR3: Hospital/Recipient Access

- FR3.1: Hospitals can **filter blood availability** by group, location, expiry.
- FR3.2: Hospitals can **request/reserve blood units**.

### FR4: AI Prediction

- FR4.1: AI model will **predict demand trends** (daily, weekly, monthly).
- FR4.2: System will **suggest optimal dates/locations** for donation drives.

### FR5: Reporting and Dashboard

- FR5.1: Blood bank dashboards will show **stock levels, demand trends, usage history**.
- FR5.2: System admin dashboard will show **global statistics** across all banks.

### FR6: Communication

- FR6.1: System will send **SMS/Email notifications** to donors and hospitals.
- FR6.2: Urgent requests will trigger **standby donor alerts**.

---

### 3.2 Non-Functional Requirements

### NFR1: Performance

- System must handle **100 requests/sec** with latency < 300ms.

### NFR2: Security

- All sensitive data must be **encrypted (AES-256 at rest, TLS 1.3 in transit)**.
- Authentication via **OAuth 2.0 / Firebase Auth**.

### NFR3: Availability & Reliability

- Uptime requirement: **99.9% SLA**.
- Backup & recovery system must restore within **30 minutes**.

### NFR4: Scalability

- Must support scaling from **1000 → 50,000 users** without redesign.

### NFR5: Usability

- UI must be **responsive, multilingual, and accessible (WCAG 2.1 compliant)**.

---

## **4. External Interface Requirements**

### 4.1 User Interfaces

- **Web Application**: React-based interface with dashboards.
- **Mobile-Friendly Views**: Responsive design for donors/hospitals.

### 4.2 Hardware Interfaces

- Works on any modern **PC/mobile browser**.

### 4.3 Software Interfaces

- **Database**: Cloud SQL (MySQL/PostgreSQL).
- **AI**: GCP AI/ML APIs, BigQuery ML.
- **Notification Services**: Twilio (SMS), SendGrid (Email).

### 4.4 Communication Interfaces

- REST API (JSON-based) between frontend and backend.
- Secure HTTPS protocol for all communication.

---

## **5. System Architecture (High Level)**

- **Frontend (React, hosted on GCP App Engine/Cloud Run)**
- **Backend (Node.js/Express, GCP Cloud Run)**
- **Database (Cloud SQL – MySQL/Postgres)**
- **AI Prediction Service (GCP BigQuery ML / Cloud Functions)**
- **Authentication (OAuth 2.0 / Firebase Auth)**
- **Notification Service (Twilio/SendGrid)**

---

## **6. Project Timeline & Effort (10 Weeks, 4 Members)**

| Phase | Duration | Team Allocation |
| --- | --- | --- |
| Requirements & Design | 1 week | All 4 |
| Database & Backend Setup | 2 weeks | 2 backend devs |
| Frontend Development | 3 weeks | 2 frontend devs |
| AI Model Development | 2 weeks | 1 backend dev + 1 analyst |
| Integration & Testing | 1.5 weeks | All |
| Deployment on GCP | 0.5 weeks | DevOps |
| Final QA & Documentation | 0.5 weeks | All |

---

## **7. Appendices**

- Future scope: Mobile app (Flutter), Blockchain for donor history, Integration with government health APIs.
- Risks: Low donor adoption, inaccurate AI predictions due to insufficient data.

---