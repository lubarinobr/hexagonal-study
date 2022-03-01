FROM maven:3.8.3-jdk-11

ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

COPY pom.xml $APP_HOME/pom.xml
COPY mvnw $APP_HOME/mvnw
COPY src $APP_HOME/src
COPY src/main/resources/db $APP_HOME/db
COPY flyway.conf $APP_HOME/flyway.conf

RUN mvn clean package