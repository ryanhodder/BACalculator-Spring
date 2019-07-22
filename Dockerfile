FROM openjdk:8-jdk-alpine
COPY target/BACalculator-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "BACalculator-0.0.1-SNAPSHOT.jar"]