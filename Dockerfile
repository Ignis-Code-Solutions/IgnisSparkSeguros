# Etapa 1: Build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Permissão de execução para o Maven Wrapper
RUN chmod +x ./mvnw

RUN ./mvnw install -DskipTests

# Descompacta o JAR para otimizar o cache de camadas do Docker
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Etapa 2: Imagem final para execução (usando JRE para reduzir o tamanho)
FROM eclipse-temurin:17-jre

VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Executa a aplicação mapeando as classes e bibliotecas descompactadas
ENTRYPOINT ["java","-cp","app:app/lib/*","com.generation.ignisspark.IgnissparkApplication"]