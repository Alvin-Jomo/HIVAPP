package com.example.hivapp;

public class Booking {
    private String fullname;
    private String address;
    private String contact;
    private int pincode;
    private String date;
    private String time;
    private float price;
    private String type;

    public Booking() {
        // Default constructor required for Firebase
    }

    public Booking(String fullname, String address, String contact, int pincode, String date, String time, float price, String type) {
        this.fullname = fullname;
        this.address = address;
        this.contact = contact;
        this.pincode = pincode;
        this.date = date;
        this.time = time;
        this.price = price;
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
