# 🎬 TMDB Movie Search CLI

Aplicación de línea de comandos para consultar películas desde la API de The Movie Database (TMDB). Obtén información actualizada sobre películas en cartelera, populares, mejor valoradas y próximos estrenos.

## Requisitos

- Java 11 o superior
- Maven 3.6+
- Token de API de TMDB (gratuito)

## Instalación

### 1. Clona el repositorio

```bash
git clone https://github.com/DiegoBauti/TMDBCLITool.git
cd tmdb-movie-app
```

### 2. Configura tu token de TMDB

Crea tu archivo de configuración:

```bash
cp config.properties.example config.properties
```

Edita `config.properties` y añade tu token:

```properties
TMDB_TOKEN=tu_token_real_aqui
```

**¿Cómo obtener tu token?**

1. Crea una cuenta en [TMDB](https://www.themoviedb.org/signup)
2. Ve a tu perfil → Settings → API
3. Solicita una API Key (es gratis)
4. Copia el token de lectura (Read Access Token)

### 3. Compila el proyecto

```bash
mvn clean install
```

## Uso

```bash
java -jar target/tmdb-movie-app.jar --type [tipo]
```

### Tipos disponibles

| Comando | Descripción |
|---------|-------------|
| `playing` | Películas actualmente en cartelera |
| `popular` | Películas más populares del momento |
| `top` | Películas mejor valoradas de todos los tiempos |
| `upcoming` | Próximos estrenos |

### Ejemplos

```bash
# Ver películas en cartelera
java -jar target/tmdb-movie-app.jar --type playing

# Ver películas populares
java -jar target/tmdb-movie-app.jar --type popular

# Ver películas mejor valoradas
java -jar target/tmdb-movie-app.jar --type top

# Ver próximos estrenos
java -jar target/tmdb-movie-app.jar --type upcoming
```