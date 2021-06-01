FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/spring-boot-crud-operation.0.0.1-SNAPSHOT.jar spring-boot-crud-operation.0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-crud-operation.0.0.1-SNAPSHOT.jar"]
