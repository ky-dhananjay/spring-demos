FROM openjdk:17-jdk-slim
WORKDIR /app
# Add the application jar to container root>accounts directory
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar ./eurekaserver/eurekaserver-0.0.1-SNAPSHOT.jar
# Install curl
RUN apt-get update

RUN apt-get install -y curl
#execute the application
ENTRYPOINT ["java", "-jar", "./eurekaserver/eurekaserver-0.0.1-SNAPSHOT.jar"]