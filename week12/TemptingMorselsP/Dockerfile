FROM openjdk:8-jdk-alpine as build
ADD tempting-morsels.jar tempting-morsels.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/tempting-morsels.jar"]