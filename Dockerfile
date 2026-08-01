FROM eclipse-temurin:21-jre

WORKDIR /app

# Non-root user security practice
USER nobody

COPY target/*.jar service.jar

EXPOSE 8083 8080

ENTRYPOINT ["java", "-jar", "service.jar"]
