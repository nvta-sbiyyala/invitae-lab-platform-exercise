# Build project with gradle
FROM openjdk:11-jre-slim as builder
COPY . .
RUN ./gradlew build

# Copy the jar into a new image
FROM openjdk:11-jre-slim
COPY --from=builder /workspace/build/libs/lab-platform-exercise.jar ./exercise.jar
CMD ["java","-jar","/exercise.jar"]
