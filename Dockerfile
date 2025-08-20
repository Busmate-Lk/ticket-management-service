FROM openjdk:17-jdk
WORKDIR /app
COPY *.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080