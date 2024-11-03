FROM openjdk:17-jdk-alpine
VOLUME /tmp

ARG VERSION
COPY target/eurekaserver-${VERSION}.jar eureka-server.jar

ENV SPRING_PROFILES_ACTIVE local

# 暴露端口 8082
EXPOSE 9090

ENTRYPOINT ["java","-jar","/eureka-server.jar"]

# VERSION=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
# docker build --build-arg VERSION=$VERSION -t eureka-server:$VERSION .
# docker run -d -p 9090:9090 --name eureka-server docker.io/library/eureka-server:$VERSION
