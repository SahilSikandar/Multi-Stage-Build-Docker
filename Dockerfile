# Stage 1: Build stage
FROM ubuntu:latest AS build

# Install Java Development Kit (JDK) to compile the Java program
RUN apt-get update && apt-get install -y openjdk-11-jdk wget

# Set the working directory inside the container
WORKDIR /app

# Copy your Java source file to the build stage
COPY Calculator.java .

# Compile the Java file (this will generate a .class file)
RUN javac Calculator.java

# Stage 2: Runtime stage using OpenJDK
FROM openjdk:11-jre-slim

# Set the working directory inside the runtime stage
WORKDIR /app

# Copy only the compiled .class file from the build stage to the runtime stage
COPY --from=build /app/Calculator.class /app/Calculator.class

# Run the compiled Java class file directly
CMD ["java", "Calculator"]
