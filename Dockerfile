FROM openjdk:17-jdk

# Copy the jar file to the working directory
COPY target/*.jar /patient-service-0.0.1-SNAPSHOT.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "patient-service-0.0.1-SNAPSHOT.jar"]

