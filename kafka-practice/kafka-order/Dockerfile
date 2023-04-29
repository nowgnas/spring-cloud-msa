FROM adoptopenjdk:11-hotspot AS builder

COPY kafka-order/gradlew .
COPY kafka-order/gradle gradle
COPY kafka-order/build.gradle .
COPY kafka-order/settings.gradle .
COPY kafka-order/src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]