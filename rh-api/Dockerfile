FROM maven:3.8.5-openjdk-17
WORKDIR /rh-api
COPY . .
RUN mvn clean install -DskipTests
RUN cp /rh-api/target/rh-api-0.0.1-SNAPSHOT.jar /rh-api/rh-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","rh-api-0.0.1-SNAPSHOT.jar" ]