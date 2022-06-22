FROM openjdk:18

ENV ENVIRONMENT=prod

ADD target/quiz-0.0.1-SNAPSHOT.jar app.jar

CMD [ "sh", "-c", "java -jar /app.jar" ]