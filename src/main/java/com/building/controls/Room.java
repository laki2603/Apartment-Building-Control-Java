package com.building.controls;

import java.util.Random;

public class Room {
    private static int idCounter = 1;
    private final int roomId;
    protected double temperature;
    protected boolean heatingEnabled;
    protected boolean coolingEnabled;
    private final Random random = new Random();

    public Room() {
        this.roomId = idCounter++;
        this.temperature = generateRandomTemperature();
        this.heatingEnabled = false;
        this.coolingEnabled = false;
    }

    private double generateRandomTemperature() {
        return 10 + random.nextDouble() * 30;  // Generates temperature between 10 and 40 degrees
    }

    public void adjustTemperature(double requestedTemperature) {
        double threshold = 0.5;  // Threshold for "close enough"
        if (Math.abs(temperature - requestedTemperature) <= threshold) {
            heatingEnabled = false;
            coolingEnabled = false;
        } else if (temperature < requestedTemperature) {
            heatingEnabled = true;
            coolingEnabled = false;
        } else {
            heatingEnabled = false;
            coolingEnabled = true;
        }
    }

    public void updateTemperature() {
        if (heatingEnabled) {
            temperature += 0.1;  // Slow increase in temperature when heating
        } else if (coolingEnabled) {
            temperature -= 0.1;  // Slow decrease in temperature when cooling
        }
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId + ", Temperature: " + temperature + "°C, Heating: " + (heatingEnabled ? "ON" : "OFF") + ", Cooling: " + (coolingEnabled ? "ON" : "OFF");
    }
}
