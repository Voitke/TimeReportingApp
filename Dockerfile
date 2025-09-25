FROM openjdk:17-jdk-alpine

ARG JAR_PATH=build/libs/timereportingapp-0.0.1-plain.jar

WORKDIR /app

COPY ${JAR_PATH} /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]