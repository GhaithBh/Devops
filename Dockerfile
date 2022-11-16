FROM openjdk:11
EXPOSE 8089
COPY ./target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]

# Run vulnerability scan on build image
FROM build AS vulnscan
COPY --from=aquasec/trivy:latest /usr/local/bin/trivy /usr/local/bin/trivy
RUN trivy rootfs --no-progress /
