# BuildingControls Application

This is a building controls program that manages temperature control for rooms, apartments, and common rooms in a building.

## Features
- Room temperature management (heating/cooling)
- User can adjust building temperature
- Supports apartments and common rooms (Gym, Library, Laundry)
- User can add rooms to the building.

## Requirements
- **Java Version:** Java 19
- **Gradle Version:** Gradle 8.13 (via Gradle Wrapper, no need to install separately)
- **Docker:** Ensure Docker is installed if you want to run the application in a container.

## Build and Run using Gradle Wrapper

1. **Navigate to the project directory:**

2. **Build the project:**
   Run the following command based on your operating system:

   - **Windows:**
     ```bash
     .\gradlew build
     ```

   - **Mac/Linux:**
     ```bash
     ./gradlew build
     ```

3. **Run the application:**
   - **Windows:**
     ```bash
     .\gradlew run
     ```

   - **Mac/Linux:**
     ```bash
     ./gradlew run
     ```

This will automatically download the required Gradle version (8.13) and run the application.

## Docker

You can build and run the application in a Docker container.

1. **Build the Docker image:**
   ```bash
   docker build -t buildingcontrols


2. **Run the Docker image:**
   ```bash
   docker run -it buildingcontrols