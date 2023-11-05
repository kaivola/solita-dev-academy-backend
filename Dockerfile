FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/dev-academy-assignment-*.jar app.jar

EXPOSE 8080
CMD ["java", \
    "-Ddb_user=${DB_USER}", \
    "-Ddb_password=${DB_PASSWORD}", \
    "-Ddb_host=${DB_HOST}", \
    "-jar", \
    "/app/app.jar"]