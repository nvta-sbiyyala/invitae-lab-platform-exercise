FROM openjdk:11-jre-slim as builder

# Build project with gradle
WORKDIR /workspace
COPY . .
RUN ./gradlew build

# Store build result as jar file
FROM openjdk:11-jre-slim

CMD ["java","-jar","/exercise.jar"]
