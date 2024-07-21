# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR do projeto para o diretório de trabalho do contêiner
COPY build/libs/*.jar app.jar

# Comando para executar o aplicativo Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]