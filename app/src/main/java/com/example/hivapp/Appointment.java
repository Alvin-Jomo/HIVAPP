package com.example.hivapp;

public class Appointment {
    private String patientName;
    private String address;
    private String contact;
    private String fees;
    private String date;
    private String time;

    public Appointment(String patientName, String address, String contact, String fees, String date, String time, float v) {
        this.patientName = patientName;
        this.address = address;
        this.contact = contact;
        this.fees = fees;
        this.date = date;
        this.time = time;
    }

    // Getters and setters for all attributes
    public String getPatientName() {
        return patientName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.isEmpty()) {
            this.patientName = patientName;
        } else {
            // Handle invalid input, throw an exception or log a message
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientName='" + patientName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public Appointment(String patientName, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
    }

}