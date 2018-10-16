FROM openjdk:8-jdk-alpine
COPY ./target/logement-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
EXPOSE 8083
CMD ["java", "-jar", "logement-1.0-SNAPSHOT.jar"]
