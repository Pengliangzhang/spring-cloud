FROM openjdk:17-jdk-alpine
VOLUME /tmp

ARG VERSION
COPY target/configserver-${VERSION}.jar config-server.jar

# 暴露端口 8082
EXPOSE 9080

ENTRYPOINT ["java","-jar","/config-server.jar"]

# VERSION=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
# docker build --build-arg VERSION=$VERSION -t config-server:$VERSION .
# docker run -d -p 9080:9080 --name configserver docker.io/library/config-server
