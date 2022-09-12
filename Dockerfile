FROM openjdk:11.0.16
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} singup-0.0.1.jar
ENTRYPOINT ["java","-jar","/singup-0.0.1.jar"]