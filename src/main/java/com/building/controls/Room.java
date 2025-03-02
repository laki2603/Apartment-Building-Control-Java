package com.building.controls;

import java.util.Random;

public class Room {
    private static int idCounter = 1;
    private int id;
    private double temperature;
    private boolean heatingEnabled;
    private boolean coolingEnabled;

    public Room() {
        this.id = idCounter++;
        this.temperature = new Random().nextDouble() * (40 - 10) + 10;  // Random temp between 10 and 40
        this.heatingEnabled = false;
        this.coolingEnabled = false;
    }

    public double getTemperature() {
        return temperature;
    }

    public void adjustTemperature(double requestedTemperature) {
        if (temperature < requestedTemperature) {
            heatingEnabled = true;
            coolingEnabled = false;
        } else if (temperature > requestedTemperature) {
            heatingEnabled = false;
            coolingEnabled = true;
        } else {
            heatingEnabled = false;
            coolingEnabled = false;
        }
    }

    public void updateTemperature() {
        if (heatingEnabled) {
            temperature += 0.1;  // Temperature increases slowly if heating is enabled
        } else if (coolingEnabled) {
            temperature -= 0.1;  // Temperature decreases slowly if cooling is enabled
        }
    }

    @Override
    public String toString() {
        return "Room ID: " + id + " | Temp: " + temperature + "°C | Heating: " + heatingEnabled + " | Cooling: " + coolingEnabled;
    }
}

