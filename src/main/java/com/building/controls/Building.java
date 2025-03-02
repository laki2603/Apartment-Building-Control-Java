package com.building.controls;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double requestedTemperature = 20.0;  // Default temperature set to 20°C
    public final List<Apartment> apartments;
    public final List<CommonRoom> commonRooms;

    public Building() {
        apartments = new ArrayList<>();
        commonRooms = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
        recalculateHeatingAndCooling();  // Recalculate after adding a new apartment
    }

    public void addCommonRoom(CommonRoom commonRoom) {
        commonRooms.add(commonRoom);
        recalculateHeatingAndCooling();  // Recalculate after adding a new common room
    }

    public void setRequestedTemperature(double requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
        recalculateHeatingAndCooling();  // Recalculate when temperature changes
    }

    private void recalculateHeatingAndCooling() {
        apartments.forEach(apartment -> apartment.adjustTemperature(requestedTemperature));
        commonRooms.forEach(commonRoom -> commonRoom.adjustTemperature(requestedTemperature));
    }

    public void printStatus() {
        System.out.println("\n--- Building Status ---");
        System.out.println("Requested Temperature: " + requestedTemperature + "°C");
        apartments.forEach(System.out::println);
        commonRooms.forEach(System.out::println);
        System.out.println("-----------------------\n");
    }
}
