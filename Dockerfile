# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Defina a variável de ambiente PORT, que será usada pelo Vercel
ENV PORT 8080

# Exponha a porta 8080
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
