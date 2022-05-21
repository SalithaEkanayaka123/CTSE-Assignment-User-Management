FROM openjdk:11
LABEL maintainer="salitha ekanayaka"
ADD target/assignment-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
