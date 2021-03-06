FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /app
RUN git clone https://github.com/ernestoagc/demo-api.git
RUN chmod -R 777 demo-api
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean install -DskipTests=true

FROM openjdk:11.0.8-jre-slim
COPY --from=builder /app/target/demo-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7400
CMD ["java", "-jar","/app.jar"]