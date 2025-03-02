# Use OpenJDK image
FROM openjdk:19-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Gradle wrapper files
COPY gradlew /app/gradlew
COPY gradlew.bat /app/gradlew.bat
COPY gradle /app/gradle

# Copy build.gradle and settings.gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle

# Copy source code
COPY src /app/src

# Grant permission to run the Gradle wrapper
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew build

# Set the entry point to run the built application
CMD ["java", "-jar", "build/libs/Apartment-Building-Control-Java-1.0-SNAPSHOT.jar"]


