# Etapa 1: compila o projeto
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -B -q dependency:go-offline
COPY src/ src/
RUN ./mvnw -B -q package -DskipTests

# Etapa 2: imagem final só com o JRE e o .jar
FROM eclipse-temurin:25-jre
WORKDIR /app
RUN useradd --system --no-create-home appuser
COPY --from=build /app/target/*.jar app.jar
USER appuser
EXPOSE 8080
# Limita a memória da JVM ao tamanho do contêiner (o plano gratuito do Render tem 512 MB).
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-XX:+UseSerialGC", "-jar", "app.jar"]
