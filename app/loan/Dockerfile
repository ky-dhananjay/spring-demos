FROM openjdk:17-jdk-slim
WORKDIR /app
# Add the application jar to container root>accounts directory
COPY target/loan-0.0.1-SNAPSHOT.jar ./loans/loans-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java", "-jar", "./loans/loans-0.0.1-SNAPSHOT.jar"]