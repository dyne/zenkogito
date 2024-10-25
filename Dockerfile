FROM maven:3-amazoncorretto-17-alpine AS build
WORKDIR /home/app
COPY . .
RUN mvn clean package

FROM amazoncorretto:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /home/app/target/zenkogito-1.0-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]