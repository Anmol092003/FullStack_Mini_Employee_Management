# Step 1: Use Maven with OpenJDK 17 to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (for build caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight OpenJDK 17 image to run the app
FROM openjdk:17-slim
WORKDIR /app

# Copy the built jar file from the previous stage
COPY --from=build /app/target/fullstack-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
