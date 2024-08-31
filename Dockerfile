FROM openjdk:11
EXPOSE 8080
ADD target/Pragason-app-ecs.jar Pragason-app-ecs.jar
ENTRYPOINT ["java", "-jar", "Pragason-app-ecs.jar"]