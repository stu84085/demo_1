FROM openjdk:latest
RUN mkdir /opt/application
COPY demo-0.0.1-SNAPSHOT.jar /opt/application
WORKDIR /opt/application

EXPOSE 8080
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]