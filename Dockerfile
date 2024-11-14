# Build phase
FROM ubuntu:22.04 AS build

RUN apt-get update \
    && apt-get install openjdk-21-jdk -y \
    && apt-get install maven -y \
    && apt-get clean

COPY . .

RUN mvn clean install -DskipTests

# Execution phase
FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /target/mobiliza*.jar mobiliza.jar

ENV DB_URL=${DB_URL}
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}
ENV JWT_PUBLIC_KEY=${JWT_PUBLIC_KEY}
ENV JWT_PRIVATE_KEY=${JWT_PRIVATE_KEY}

ENTRYPOINT [ "java", "-jar", "mobiliza.jar" ]