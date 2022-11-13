FROM openjdk:11
EXPOSE 8089
COPY ./target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]