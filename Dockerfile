FROM openjdk:8
ADD target/achat-1.0.jar achat.jar
ENTRYPOINT ["java", "-jar", "achat.jar"]
Expose 8089