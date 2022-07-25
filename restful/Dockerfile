FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S springgroup && adduser -S spring -G springgroup
USER spring:springgroup
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]