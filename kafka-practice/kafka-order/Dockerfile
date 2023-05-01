FROM adoptopenjdk:11-hotspot AS builder
WORKDIR /app
COPY kafka-order/gradlew .
COPY kafka-order/gradle gradle
COPY kafka-order/build.gradle .
COPY kafka-order/settings.gradle .
COPY kafka-order/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", \
        "-Dspring.profiles.active=docker", \
        "/app/app.jar"]
