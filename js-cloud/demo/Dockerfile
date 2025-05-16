FROM eclipse-temurin:21 AS bulider
WORKDIR workspace
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} demo.jar
RUN java -Djarmode=layertools -jar demo.jar extract

FROM eclipse-temurin:21
RUN useradd spring
USER spring
WORKDIR workspace
COPY --from=bulider workspace/dependencies/ ./
COPY --from=bulider workspace/spring-boot-loader/ ./
COPY --from=bulider workspace/snapshot-dependencies/ ./
COPY --from=bulider workspace/application/ ./
ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]