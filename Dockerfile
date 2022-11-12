FROM eclipse-temurin:11-jdk-alpine
ADD http://192.168.1.11:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat.jar
ENTRYPOINT ["java", "-jar", "/achat.jar"]
EXPOSE 8089
