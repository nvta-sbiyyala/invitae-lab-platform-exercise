FROM gradle:7.1.1-jdk11 as builder

# Build project with gradle
WORKDIR /workspace
COPY . .
RUN ./gradlew build

# Store build result as jar file
FROM openjdk:11-jre-slim
ARG uid=1001
ARG user=interviewee

RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid ${uid} ${user}

COPY --chown=${user}:${user} --from=builder /workspace/build/libs/lab-platform-exercise-*.jar exercise.jar

EXPOSE 8080

USER ${uid}

CMD ["java","-jar","/exercise.jar"]