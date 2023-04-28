FROM adoptopenjdk:11-hotspot AS builder

COPY discovery/gradlew .
COPY discovery/gradle gradle
COPY discovery/build.gradle .
COPY discovery/settings.gradle .
COPY discovery/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]