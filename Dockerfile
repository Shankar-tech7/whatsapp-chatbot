FROM openjdk:17-jdk-slim-bullseye
COPY target/whatsapp-chatbot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]