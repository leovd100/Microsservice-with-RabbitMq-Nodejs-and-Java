FROM openjdk:21-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8082
CMD ["java", "-jar", "/app/app.jar"]