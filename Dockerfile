# Usa una imagen base oficial de Eclipse Temurin con JDK 21
FROM eclipse-temurin:21-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Da permisos de ejecución al wrapper de Maven (por si es necesario)
RUN chmod +x mvnw

# Compila el proyecto y genera el JAR, sin correr tests
RUN ./mvnw clean package -DskipTests

# Expone el puerto que usa Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["sh", "-c", "java -jar target/*.jar"]
