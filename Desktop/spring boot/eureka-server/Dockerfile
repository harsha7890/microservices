FROM openjdk:10-jdk

ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar /usr/app/eureka-server-0.0.1-SNAPSHOT.jar

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]