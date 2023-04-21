FROM adoptopenjdk:11-hotspot AS order

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar

FROM adoptopenjdk:11-hotspot
COPY --from=order build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
