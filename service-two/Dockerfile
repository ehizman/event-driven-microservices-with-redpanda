# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
RUN ./mvnw package
FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8081
COPY --from=build /app/target/service-two-*.jar /service-two.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service-two.jar"]