# Use a base image with Maven installed to build the application
FROM maven:3.6.3-openjdk-11 AS build

# Set working directory
WORKDIR /app

# Copy Maven dependency files
COPY pom.xml .

# Download dependencies (avoid unnecessary offline mode)
RUN mvn dependency:get

# Copy the application source code
COPY src ./src

# Build the application with tests (optional)
RUN mvn package

# Create the final Docker image with OpenJDK (slim version for smaller image)
FROM openjdk:11-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port
EXPOSE 9090

# Improve environment variable names (use underscores instead of upper case)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql_container:3306/phaseend_project
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=123456  # Consider using secrets management for passwords

# Run the application
CMD ["java", "-jar", "app.jar"]
