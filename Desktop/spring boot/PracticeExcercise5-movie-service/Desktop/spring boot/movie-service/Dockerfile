FROM openjdk:10-jdk

ADD ./target/movie-cruiser-app-0.0.1-SNAPSHOT.jar /usr/app/movie-cruiser-app-0.0.1-SNAPSHOT.jar

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "movie-cruiser-app-0.0.1-SNAPSHOT.jar"]