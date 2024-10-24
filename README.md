# spring-cloud

# For config server
# Build Docker Image
### ./mvnw spring-boot:build-image -Dspring-boot.build-image.environment."SPRING_PROFILES_ACTIVE=docker"
$ docker run -d -p 8081:8072 --name configserver docker.io/library/configserver:0.0.1-SNAPSHOT



