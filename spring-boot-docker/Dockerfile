# base image
FROM amazoncorretto:17

# JAR file path
ARG JAR_FILE=./build/libs/*.jar

# Copy JAR file from the build context into Docker image
COPY ${JAR_FILE} application.jar

CMD apt-get update -y

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]