FROM adoptopenjdk:11-hotspot AS discovery

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=discovery build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
