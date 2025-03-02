package com.building.controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Building {
    private double requestedTemperature = 25.0;
    private List<Apartment> apartments;
    private List<CommonRoom> commonRooms;
    private Timer timer;

    public Building() {
        apartments = new ArrayList<>();
        commonRooms = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public void addCommonRoom(CommonRoom commonRoom) {
        commonRooms.add(commonRoom);
    }

    public void setRequestedTemperature(double requestedTemperature) {
        this.requestedTemperature = requestedTemperature;
        recalculateHeatingAndCooling();
    }

    public void recalculateHeatingAndCooling() {
        apartments.forEach(apartment -> apartment.adjustTemperature(requestedTemperature));
        commonRooms.forEach(commonRoom -> commonRoom.adjustTemperature(requestedTemperature));
    }

    public void startTemperatureUpdate() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                apartments.forEach(Apartment::updateTemperature);
                commonRooms.forEach(CommonRoom::updateTemperature);
                recalculateHeatingAndCooling();
                printStatus();
            }
        }, 0, 5000);  // Update every 5 seconds
    }

    public void stopTemperatureUpdate() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void printStatus() {
        System.out.println("\n--- Building Status ---");
        System.out.println("Requested Temperature: " + requestedTemperature + "°C");
        apartments.forEach(System.out::println);
        commonRooms.forEach(System.out::println);
        System.out.println("-----------------------\n");
    }
}

