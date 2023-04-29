FROM adoptopenjdk:11-hotspot AS builder
WORKDIR /app
COPY kafka-user/gradlew .
COPY kafka-user/gradle gradle
COPY kafka-user/build.gradle .
COPY kafka-user/settings.gradle .
COPY kafka-user/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
