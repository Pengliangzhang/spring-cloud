FROM openjdk:17-jdk-alpine
VOLUME /tmp

ARG VERSION
COPY target/configserver-${VERSION}.jar config-server.jar

ENV ENCRYPT_KEY=sezpij-2pakvI-qebwoj
ENV GITHUB_USERNAME=pengliangzhang
ENV GITHUB_TOKEN=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

# 暴露端口 8082
EXPOSE 8082

ENTRYPOINT ["java","-jar","/config-server.jar"]

# VERSION=$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)
# docker build --build-arg VERSION=$VERSION -t config-server:$VERSION .
# docker run -d -p 8081:8072 --name configserver docker.io/library/config-server
