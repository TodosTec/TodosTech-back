# STAGE Build - servidor 1
FROM maven:3.8.3-openjdk-17 AS apiCadastroTodosTec

COPY . .

RUN mvn clean package -DskipTests

# STAGE Packege / Deploy - servidor 2

FROM openjdk:17-jdk-slim

COPY --from=apiCadastroTodosTec /target/apiCadastroTodosTec-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "api.jar"]
