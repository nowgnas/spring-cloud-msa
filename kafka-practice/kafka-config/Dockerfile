FROM adoptopenjdk:11-hotspot AS builder

COPY kafka-config/gradlew .
COPY kafka-config/gradle gradle
COPY kafka-config/build.gradle .
COPY kafka-config/settings.gradle .
COPY kafka-config/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]