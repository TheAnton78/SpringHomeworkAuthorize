FROM openjdk:8-jdk-alpine

EXPOSE 8085

ADD ./build/libs/springBootHomeworkAuthorize-0.0.1-SNAPSHOT.jar app.jar


