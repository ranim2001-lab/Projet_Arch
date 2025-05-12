FROM openjdk:17-jdk-slim

WORKDIR /app

COPY serverCode/ ./serverCode/
COPY interfaceCode/ ./interfaceCode/

RUN javac serverCode/*.java interfaceCode/*.java

CMD ["java", "serverCode.Server"]

