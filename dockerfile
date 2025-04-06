FROM maven:3.9.6-eclipse-temurin-21 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -DskipTests

FROM openjdk:21-jdk-slim

COPY --from=build /app/target/desafioTransferenciaSimples-0.0.1-SNAPSHOT.jar app.jar

WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]