FROM maven:3.8.3-openjdk-17 AS build

COPY src travel-journal-api/src
COPY pom.xml travel-journal-api/pom.xml
RUN mvn -f travel-journal-api/pom.xml clean package -DskipTests

FROM openjdk:17

COPY --from=build travel-journal-api/target/travel-journal-api-0.0.1-SNAPSHOT.jar travel-journal-api.jar

ARG DB_PWD
ARG DB_HOST
ENV db_pwd=${DB_PWD}
ENV db_host=${DB_HOST}
ENTRYPOINT ["java", "-jar", "travel-journal-api.jar"]