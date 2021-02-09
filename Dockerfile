FROM openjdk:8
EXPOSE 8082
ADD target/students-0.0.1-SNAPSHOT.jar students-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/students-0.0.1-SNAPSHOT.jar"]