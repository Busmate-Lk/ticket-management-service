FROM openjdk:17-jdk-slim
WORKDIR /app
COPY *.jar app.jar
EXPOSE 8083

# Add health check for better container management
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8083/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]