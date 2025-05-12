# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy client code and interface code
COPY clientCode/ clientCode/
COPY interfaceCode/ interfaceCode/

# Compile the client Java code
RUN javac clientCode/*.java interfaceCode/*.java

# Command to run the client
CMD ["java", "clientCode.Client"]

