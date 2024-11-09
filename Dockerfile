# Usar uma imagem leve do JDK 17
FROM eclipse-temurin:17-jre

# Definir o diretório de trabalho dentro do container
WORKDIR /ac2_ca

# Copiar o arquivo .jar gerado para o diretório do container
COPY target/ac2_ca-0.0.1-SNAPSHOT.jar /ac2_ca/ac2_ca-0.0.1-SNAPSHOT.jar
EXPOSE 8585

# Comando para executar a aplicação com Java 17
CMD ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-Dserver.port=8585", "-jar", "ac2_ca-0.0.1-SNAPSHOT.jar"]