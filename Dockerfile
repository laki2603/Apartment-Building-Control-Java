# Use OpenJDK image
FROM openjdk:19-jdk-alpine

# Set working directory
WORKDIR /app

# Copy build.gradle, settings.gradle, and Gradle wrapper
COPY build.gradle /app
COPY settings.gradle /app
COPY gradlew /app
COPY gradle /app/gradle

# Copy source code
COPY src /app/src

# Build the project
RUN ./gradlew build

# Set the entry point
ENTRYPOINT ["java", "-jar", "build/libs/BuildingControls.jar"]
