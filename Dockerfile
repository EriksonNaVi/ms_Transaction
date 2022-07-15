FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/ms_Transaction-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8004
ENTRYPOINT ["java","-jar","/app.jar"]