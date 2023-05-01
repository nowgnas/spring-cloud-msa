FROM adoptopenjdk:11-hotspot AS builder
WORKDIR /app
COPY kafka-config/gradlew .
COPY kafka-config/gradle gradle
COPY kafka-config/build.gradle .
COPY kafka-config/settings.gradle .
COPY kafka-config/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", \
        "-Dspring.profiles.active=docker", \
        "/app/app.jar"]