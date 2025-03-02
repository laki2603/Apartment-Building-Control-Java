package com.building.controls;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Building building = new Building();
        Apartment apt101 = new Apartment("John");
        Apartment apt102 = new Apartment("Sarah");
        CommonRoom gym = new CommonRoom("Gym");
        CommonRoom library = new CommonRoom("Library");

        building.addApartment(apt101);
        building.addApartment(apt102);
        building.addCommonRoom(gym);
        building.addCommonRoom(library);

        // Start a thread to update temperatures every 1 minute
        Thread updateThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {  // Add this to allow thread interruption
                try {
                    Thread.sleep(60000);  // Update every 1 minute (60,000 ms)
                    building.apartments.forEach(Apartment::updateTemperature);
                    building.commonRooms.forEach(CommonRoom::updateTemperature);
                    building.printStatus();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Handle interruption properly
                    System.out.println("Temperature update interrupted.");
                }
            }
        });
        updateThread.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
        	building.printStatus();
        	System.out.println("Enter \n'status' to show current status, \n'add' to add new rooms, \n'set' to change the building temperature, \n'exit' to quit:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                updateThread.interrupt();  // Stop the background update thread
                break;  // Exit the main loop
            } else if (input.equalsIgnoreCase("status")) {
                building.printStatus();
            } else if (input.equalsIgnoreCase("set")) {
                System.out.println("Enter the new requested temperature:");
                String tempInput = scanner.nextLine();
                try {
                    double newTemp = Double.parseDouble(tempInput);
                    building.setRequestedTemperature(newTemp);
                    building.printStatus();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } else if (input.equalsIgnoreCase("add")) {
                System.out.println("Would you like to add an Apartment or Common Room? (enter 'apartment' or 'common'):");
                String roomType = scanner.nextLine();
                
                if (roomType.equalsIgnoreCase("apartment")) {
                    System.out.println("Enter the owner's name:");
                    String owner = scanner.nextLine();
                    Apartment newApartment = new Apartment(owner);
                    building.addApartment(newApartment);
                } else if (roomType.equalsIgnoreCase("common")) {
                    System.out.println("Enter the common room type (Gym, Library, Laundry):");
                    String type = scanner.nextLine();
                    CommonRoom newCommonRoom = new CommonRoom(type);
                    building.addCommonRoom(newCommonRoom);
                } else {
                    System.out.println("Invalid room type.");
                }
            } else {
                System.out.println("Invalid input.");
            }
        }

        try {
            updateThread.join();  // Wait for the background thread to stop
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        scanner.close();
    }
}
