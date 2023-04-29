FROM adoptopenjdk:11-hotspot AS builder

COPY kafka-discovery/gradlew .
COPY kafka-discovery/gradle gradle
COPY kafka-discovery/build.gradle .
COPY kafka-discovery/settings.gradle .
COPY kafka-discovery/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]