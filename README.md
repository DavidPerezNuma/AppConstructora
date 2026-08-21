# AppConstructora

API backend en Spring Boot para la gestión de proyectos de vivienda, clientes interesados y proyectos de una constructora.

## Tecnologías

- Java 21
- Spring Boot 4.1.0 (Web MVC, Data JPA, Validation)
- MySQL 8 (vía `com.mysql:mysql-connector-j`)
- Lombok
- Maven (con wrapper `mvnw` / `mvnw.cmd`)
- Docker Compose (para levantar MySQL en local)

## Estructura del proyecto

El código fuente vive en `constructora/constructora/`:

```
constructora/constructora/
├── src/main/java/com/constructora/
│   ├── ConstructoraApplication.java   # Clase principal (arranque de Spring Boot)
│   ├── config/                        # Configuración (CORS, etc.)
│   ├── dto/                           # DTOs de request/response
│   ├── entity/                        # Entidades JPA (ClienteInteresado, Proyecto, Vivienda)
│   └── enums/                         # Enums (EstadoProyecto, TipoVivienda)
├── src/main/resources/application.properties
├── src/test/java/...
├── compose.yaml                       # Servicio MySQL para desarrollo local
└── pom.xml
```

> Nota: el proyecto está en etapa inicial. Aún no incluye controladores, servicios ni repositorios (solo entidades, DTOs y configuración base).

## Requisitos previos

- [JDK 21](https://adoptium.net/) instalado y configurado (`JAVA_HOME`)
- [Docker](https://www.docker.com/) (opcional, para levantar MySQL con `compose.yaml`) o una instancia de MySQL 8 accesible localmente
- Git

No es necesario instalar Maven: el proyecto incluye el wrapper (`mvnw` / `mvnw.cmd`).

## Cómo bajar el proyecto (clonar)

```bash
git clone https://github.com/TU_USUARIO/AppConstructora.git
cd AppConstructora/constructora/constructora
```

## Cómo levantar la aplicación

### 1. Levantar la base de datos MySQL

La forma más simple es con Docker Compose, desde `constructora/constructora`:

```bash
docker compose up -d
```

Esto levanta un contenedor MySQL con:
- Base de datos: `constructora`
- Usuario root: `root` / contraseña: `root`
- Puerto expuesto: `3306`

Spring Boot detecta automáticamente este `compose.yaml` al arrancar (gracias a `spring-boot-docker-compose`), por lo que si tienes Docker corriendo, la app puede levantar el contenedor por ti.

Si prefieres usar una instancia de MySQL propia, ajusta las credenciales en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/constructora?useSSL=true&requireSSL=false&verifyServerCertificate=false&allowPublicKeyRetrieval=true&serverTimezone=America/Bogota
spring.datasource.username=root
spring.datasource.password=root
```

### 2. Ejecutar la aplicación

Desde `constructora/constructora`:

**Windows (PowerShell / cmd):**
```bash
.\mvnw.cmd spring-boot:run
```

**Linux / macOS / Git Bash:**
```bash
./mvnw spring-boot:run
```

La aplicación queda disponible en `http://localhost:8080`.

`spring.jpa.hibernate.ddl-auto=update` está configurado, por lo que el esquema de la base de datos se crea/actualiza automáticamente a partir de las entidades JPA al arrancar.

### 3. Compilar el proyecto (build)

```bash
./mvnw clean package
```

El `.jar` resultante queda en `target/`.

## Cómo correr los tests

```bash
./mvnw test
```

## Configuración adicional

- CORS: configurado en `src/main/java/com/constructora/config/CorsConfig.java`
- Puerto del servidor: `server.port=8080` (editable en `application.properties`)

## Contribuir

1. Crea una rama a partir de `main`/`master` para tu funcionalidad o fix.
2. Haz commit de tus cambios con mensajes claros.
3. Abre un Pull Request describiendo el cambio.
