FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/inst-comment-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} inst-comment.jar
ENTRYPOINT ["java","-jar","/inst-comment.jar"]