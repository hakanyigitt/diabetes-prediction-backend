#FROM maven:3.6.0-jdk-11-slim AS build
#COPY ./src /usr/src/app/src
#COPY ./pom.xml /usr/src/app

#RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:17
EXPOSE 8080
VOLUME /tmp
#WORKDIR /hr
#COPY /target/fmss-hr.jar app.jar
ADD diabetes-prediction/target/diabetes-prediction.jar diabetes-prediction.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
