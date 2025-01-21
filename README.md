![](Baner.jpeg)

![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Beta](https://img.shields.io/badge/Beta-FFA500?style=for-the-badge)
![JWT Token](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![API REST](https://img.shields.io/badge/API%20REST-0082C9?style=for-the-badge)
# API de Topicos y Respuestas 🏗️

Este proyecto es una API hecha con SpringBoot y diversas dependencias, las cuales se encuentran en el archivo `pom.xml`. El proyecto se centra en operaciones CRUD para Tópicos y Respuestas, pero para acceder a ellas, el usuario tiene que autenticarse.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Uso](#uso)
- [Autenticación](#autenticación)
- [Endpoints](#endpoints)
- [Contribuir](#contribuir)
- [Licencia](#licencia)
- [Contacto](#contacto)

# Instalación 💿

Para comenzar con este proyecto, sigue estos pasos:

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/tu-proyecto.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd tu-proyecto
    ```
3. Instala las dependencias:
    ```sh
    mvn install
    ```
# Spring Doc
En el siguiente enlace se encuentra un enlace a la documentación creaada con ayuda de la dependencia de Spring Doc.
La cual a mi parecer ejemplifica en mayor medida el funcionamiento de la API.

[Spring Doc de la API](http://localhost:8080/swagger-ui/index.html)

# Uso 🤖

Para ejecutar la aplicación, utiliza el siguiente comando:
```sh
mvn spring-boot:run
```
Una vez que la aplicación esté en funcionamiento, abre tu navegador y navega a [http://localhost:8080](http://localhost:8080).

# Autenticación

Para el proceso de autenticación, el usuario debe autenticarse para acceder a las operaciones CRUD. El proceso de autenticación genera un JWTToken, siempre y cuando el usuario exista en la base de datos. En caso contrario, deberá registrarse.

## Registro de Usuario
```sh
POST /user/register
{
  "nombre": "Nombre",
  "correo": "correo@ejemplo.com",
  "contraseña": "tuContraseña"
}
```

## Login de Usuario

```sh
POST /user/login 
{ 
  "correo": "correo@ejemplo.com", 
  "contraseña": "tuContraseña" 
}
```
Una vez autenticado, el usuario recibirá un JWTToken que deberá incluir en las cabeceras de las solicitudes a los endpoints protegidos.

# Endpoints 🕸️

#### Home Usuario
```
GET /user/{id}/home
```

#### Tópicos

- **Listar Tópicos**
  ```
  GET /topicos/listado
  ```
  
- **Crear Tópico**
  ```
  POST /topicos/crear 
  {
    "materia": "Curso/Materia del Topico"
    "titulo": "Título del Tópico",
    "descripcion": "Contenido del Tópico",
    "nombreDelUsuario": "nombre del usuario"
  }
  ```

- **Obtener Tópico por ID**
  ```
  GET /topicos/{id}
  ```
- **Actualizar Tópico**
  ```
  PUT /topicos/{id} 
  {
    "titulo": "Nuevo Título del Tópico",
    "descripcion": "Nuevo Contenido del Tópico",
    "estado": "ESTADO DEL TOPICO"
  }
  ```
- **Eliminar Tópico**
  ```
  DELETE /topicos/{id}
  ```
#### Respuestas
- **Listar Respuesta del Topico**
  ```
  GET /topicos/{id}/respuestas 
  ```
- **Crear Respuesta**
  ```
  POST /topicos/{id}/respuestas 
  {
    "nombreDelAutor": "nombre de usuario",
    "respuesta": "Contenido de la Respuesta"
  }
  ```
- **Obtener Respuesta por ID**
  ```
  GET /respuestas/{id}
  ```
- **Actualizar Respuesta**
  ```
  PUT /respuestas/{id} 
  {
    "mensaje": "Nuevo Contenido de la Respuesta"
  }
  ```
- **Eliminar Respuesta**
  ```
  DELETE topicos/{id}/respuestas/{idR}
  ```
  
#### Cursos
- **Listar Cursos**
  ```
  GET /cursos
  ```
- **Listar Cursos y Sus Topicos**
  ```
  GET /cursos/topicos
  ```

## Contribuir 👐
Si deseas contribuir al proyecto, por favor sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una rama nueva (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia 📜
Este proyecto está licenciado bajo los términos de la licencia que se encuentran en el archivo [LICENSE](LICENSE).

## Contacto 🧔
Para cualquier consulta, puedes contactarme al correo [JosueGarNu](mailto:di_josue88@outlook.com).
