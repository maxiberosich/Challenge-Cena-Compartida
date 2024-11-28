# API de Gestión de Usuarios y Platillos

Este proyecto es una API RESTful desarrollada con **Spring Boot** que permite gestionar usuarios y platillos. Los usuarios pueden ser registrados, actualizados, eliminados y consultados, mientras que los platillos pueden ser cargados, actualizados y eliminados por cada usuario.

## Tecnologías utilizadas

- **Java 17**: Lenguaje de programación utilizado.
- **Spring Boot**: Framework para el desarrollo de la API.
- **Spring Security**: Gestión de seguridad para autenticación y autorización.
- **JWT (JSON Web Tokens)**: Sistema de autenticación basado en tokens.
- **OpenAPI / Swagger**: Documentación interactiva de la API.
- **Spring Data JPA**: Acceso a bases de datos con JPA.
- **MySQL**: Base de datos relacional.
- **Flyway**: Gestión de migraciones de base de datos.

## Características de la API

### Usuarios

- **Registrar usuario**: Permite registrar un nuevo usuario en el sistema.
- **Consultar todos los usuarios**: Obtiene todos los usuarios registrados.
- **Consultar usuario por ID**: Obtiene un usuario por su ID único.
- **Consultar usuario por nombre**: Busca un usuario por su nombre.
- **Actualizar usuario**: Permite actualizar los datos de un usuario.
- **Eliminar usuario**: Elimina un usuario del sistema.

### Platillos

- **Cargar platillo**: Permite cargar un platillo asociado a un usuario.
- **Mostrar todos los platillos**: Obtiene todos los platillos registrados.
- **Mostrar platillo por ID**: Obtiene un platillo específico por su ID.
- **Actualizar platillo**: Actualiza los datos de un platillo específico.
- **Eliminar platillo**: Elimina un platillo del sistema.

## Endpoints

### Usuarios

- **POST** `/usuario`: Registrar usuario
- **GET** `/usuario/todos`: Mostrar todos los usuarios
- **GET** `/usuario/{idUsuario}`: Buscar usuario por ID
- **GET** `/usuario`: Buscar usuario por nombre
- **PUT** `/usuario/{idUsuario}`: Actualizar usuario
- **DELETE** `/usuario/{idUsuario}`: Eliminar usuario

### Platillos

- **POST** `/usuario/{idUsuario}/cargar-platillo`: Cargar un platillo para un usuario
- **GET** `/platillo/todos`: Mostrar todos los platillos
- **GET** `/platillo/{idPlatillo}`: Mostrar platillo por ID
- **PUT** `/platillo/{idUsuario}/{idPlatillo}`: Actualizar platillo
- **DELETE** `/platillo/{idPlatillo}`: Eliminar platillo

### Requisitos previos

- **Java 17** o superior.
- **Maven** para la construcción del proyecto.
- **MySQL** (u otra base de datos compatible) para almacenar los datos.

## Documentación

La documentación de la API está generada automáticamente mediante OpenAPI y se puede consultar a través de Swagger UI:

- Acceder a Swagger UI: http://localhost:8080/swagger-ui/index.html

## Seguridad

La API utiliza JWT para la autenticación y autorización. Solo los usuarios autenticados pueden crear, puntuar o eliminar mensajes. Los usuarios no autenticados pueden ver los mensajes.

## Contribución

Si deseas contribuir, por favor abre un pull request o reporta problemas en la sección de issues.
