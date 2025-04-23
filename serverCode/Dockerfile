FROM openjdk:17
WORKDIR /app

COPY interfaceCode/ interfaceCode/
COPY serverCode/ serverCode/

RUN javac interfaceCode/MyInterface.java serverCode/*.java

EXPOSE 1099

CMD ["java", "-cp", ".", "serverCode.Server"]
