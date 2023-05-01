FROM adoptopenjdk:11-hotspot AS builder
WORKDIR /app
COPY kafka-gateway/gradlew .
COPY kafka-gateway/gradle gradle
COPY kafka-gateway/build.gradle .
COPY kafka-gateway/settings.gradle .
COPY kafka-gateway/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", \
        "-Dspring.profiles.active=docker", \
        "/app/app.jar"]
