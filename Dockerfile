FROM openjdk:17-jdk-slim

ARG JAR_FILE=/js/js-cloud/kotlintest/build/libs/*.jar
COPY ${JAR_FILE} kotlintest.jar


ENTRYPOINT [ "java", "-jar","/kotlintest.jar" ]