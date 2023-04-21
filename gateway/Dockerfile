FROM adoptopenjdk:11-hotspot AS builder

COPY gateway/gradlew .
COPY gateway/gradle gradle
COPY gateway/build.gradle .
COPY gateway/settings.gradle .
COPY gateway/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
