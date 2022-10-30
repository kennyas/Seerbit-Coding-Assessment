FROM adoptopenjdk/openjdk8
VOLUME /tmp
COPY target/seerbit-assessment-0.0.1-SNAPSHOT.jar seerbit-assessment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "seerbit-assessment.jar"]