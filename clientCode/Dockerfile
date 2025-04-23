FROM openjdk:17
WORKDIR /app

COPY interfaceCode/ interfaceCode/
COPY clientCode/ clientCode/

RUN javac interfaceCode/ProductService.java clientCode/Client.java

CMD ["java", "-cp", ".", "clientCode.Client"]
