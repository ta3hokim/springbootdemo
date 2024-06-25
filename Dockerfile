# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and the build.gradle file
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

# Copy the gradle wrapper directory
COPY gradle /app/gradle

# Download the dependencies
RUN ./gradlew build -x test --no-daemon

# Copy the project source code
COPY src /app/src

# Package the application
RUN ./gradlew build -x test --no-daemon

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "build/libs/personaldemo-0.0.1-SNAPSHOT.jar"]