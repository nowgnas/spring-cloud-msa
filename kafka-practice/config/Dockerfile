FROM adoptopenjdk:11-hotspot AS builder

COPY config/gradlew .
COPY config/gradle gradle
COPY config/build.gradle .
COPY config/settings.gradle .
COPY config/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]