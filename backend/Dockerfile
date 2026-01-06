FROM eclipse-temurin:25-jre-jammy

ARG JAR_PATH=build/libs/*.jar

WORKDIR /app

COPY ${JAR_PATH} /app/app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar"]