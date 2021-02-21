package com.example.crowdmanagementsystem;

import com.google.firebase.Timestamp;

public class Event {
    private String id;
    private String organizer;
    private int capacity;
    private int contactno;
    private Timestamp time;
    private String address;

    public Event(String id, String organizer, int capacity, int contactno, Timestamp time, String address) {
        this.id = id;
        this.organizer = organizer;
        this.capacity = capacity;
        this.contactno = contactno;
        this.time = time;
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getContactno() {
        return contactno;
    }

    public void setContactno(int contactno) {
        this.contactno = contactno;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}
