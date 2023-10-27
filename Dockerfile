FROM maven:3.9.5-eclipse-temurin-17 AS maven-build
WORKDIR /app
COPY . .
RUN mvn -B -DskipTests clean package

FROM openjdk:17.0
WORKDIR /app
COPY --from=maven-build /app/target/springmart-backend-0.0.1-SNAPSHOT.jar ./springmart-backend.jar
EXPOSE 9090
CMD ["java", "-jar", "springmart-backend.jar"]

