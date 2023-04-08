FROM eclipse-temurin
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

#Run tests
RUN ./mvnw test

CMD ["./mvnw", "spring-boot:run"]