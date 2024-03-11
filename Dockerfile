# Use a base image with Java and Maven installed
FROM maven:3.6.3-openjdk-11 AS build

# Set working directory
WORKDIR /app

# Copy Maven dependency files
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create the final Docker image
FROM openjdk:11

# Set working directory
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port
EXPOSE 9090

#Configured My MYSQL container Password
# Define environment variables for MySQL connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql_container:3306/phaseendproject
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=123456

# Run the application
CMD ["java", "-jar", "app.jar"]
