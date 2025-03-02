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

        building.startTemperatureUpdate();  // Start temperature update

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter new requested temperature (or 'exit' to quit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double newTemp = Double.parseDouble(input);
                building.setRequestedTemperature(newTemp);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        building.stopTemperatureUpdate();  // Stop timer on exit
        scanner.close();
    }
}

