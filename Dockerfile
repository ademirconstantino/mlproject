FROM openjdk:11
ADD target/mlproject-1.0-SNAPSHOT.jar mlproject.jar
ENTRYPOINT ["java", "-jar","mlproject.jar"]
EXPOSE 8080