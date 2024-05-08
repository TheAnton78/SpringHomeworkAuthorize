FROM openjdk:17-jdk-alpine

EXPOSE 8085

ADD ./build/libs/springBootHomeworkAuthorize-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
