FROM jelastic/maven:3.9.5-openjdk-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM bellsoft/liberica-openjdk-alpine-musl:21
WORKDIR /app
COPY --from=build /app/target/adapter.jar app.jar 
CMD ["java", "-jar", "app.jar"]  
