FROM adoptopenjdk:11-hotspot AS builder
WORKDIR /app
COPY kafka-discovery/gradlew .
COPY kafka-discovery/gradle gradle
COPY kafka-discovery/build.gradle .
COPY kafka-discovery/settings.gradle .
COPY kafka-discovery/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", \
        "-Dspring.profiles.active=docker", \
        "/app/app.jar"]
