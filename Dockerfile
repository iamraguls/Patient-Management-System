# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk

VOLUME /tmp

# Copy the built Spring Boot JAR file to the container
COPY target/patient-management.jar patient-management.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["java", "-jar", "patient-management.jar"]


