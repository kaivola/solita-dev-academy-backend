FROM maven:3.9.5-eclipse-temurin-17-alpine AS build

WORKDIR /app
COPY . /app
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
ARG JAR=dev-academy-assignment-0.0.1-SNAPSHOT.jar

WORKDIR /app
COPY --from=build /app/target/${JAR} /app

EXPOSE 8080
CMD ["java", \
    "-Ddb_user=${DB_USER}", \
    "-Ddb_password=${DB_PASSWORD}", \
    "-Ddb_host=${DB_HOST}", \
    "-jar", \
    "/app/dev-academy-assignment-0.0.1-SNAPSHOT.jar"]