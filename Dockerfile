FROM openjdk:17
VOLUME /tmp
COPY target/dynamo-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
