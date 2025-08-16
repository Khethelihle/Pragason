FROM openjdk:21
EXPOSE 8080
ADD build/libs/aws-project-pragason-backend-api-0.0.1-SNAPSHOT.jar aws-project-pragason-backend-api-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "aws-project-pragason-backend-api-0.0.1-SNAPSHOT.jar"]