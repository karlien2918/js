FROM openjdk:17-jdk-slim

ARG JAR_FILE=/home/runner/work/js/js/js-cloud/kotlintest/build/libs/*.jar
COPY ${JAR_FILE} kotlintest.jar


ENTRYPOINT [ "java", "-jar","/kotlintest.jar" ]