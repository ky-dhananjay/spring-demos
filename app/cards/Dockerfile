FROM openjdk:17-jdk-slim
WORKDIR /app
# Add the application jar to container root>accounts directory
COPY target/cards-0.0.1-SNAPSHOT.jar ./cards/cards-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java", "-jar", "./cards/cards-0.0.1-SNAPSHOT.jar"]