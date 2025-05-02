FROM openjdk:17-jdk-slim
WORKDIR /app
# Add the application jar to container root>accounts directory
COPY target/accounts-0.0.1-SNAPSHOT.jar ./accounts/accounts-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java", "-jar", "./accounts/accounts-0.0.1-SNAPSHOT.jar"]