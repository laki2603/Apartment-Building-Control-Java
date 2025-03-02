package com.building.controls;

public class Apartment extends Room {
    private String owner;

    public Apartment(String owner) {
        super();  // Call parent class Room's constructor
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Apartment owned by " + owner + " | " + super.toString();
    }
}

