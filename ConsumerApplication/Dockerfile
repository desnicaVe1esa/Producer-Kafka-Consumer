FROM openjdk:11
ADD target/leveldown.jar /opt/leveldown/leveldown.jar
WORKDIR /opt/leveldown
ENV TZ Europe/Moscow
ENTRYPOINT ["java", "-jar", "/opt/leveldown/leveldown.jar"]