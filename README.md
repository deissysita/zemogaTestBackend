# PRUEBA TECNICA JAVA - ZEMOGA

Portfolio JAVA WEB APP

## Comenzando 🚀

Descargar el proyecto de backend desde la siguiente URL:
https://github.com/deissysita/zemogaTestBackend.git

Descargar el proyecto de frontend desde la siguiente URL:
https://github.com/deissysita/zemogaTestFrontEnd.git

### Pre-requisitos 📋

_Para la ejecución del proyecto se necesita las siguientes herramientas:_

** Spring tool suite 4: agregar  JunitTools y eclipse web developers tools desde Marketplace
** JDK 11
** Node.js 16.14.0
** Angular cli 11.0.4
** NPM 8.3.1
** MySQL WorkBench 8
** Postman 
** Lombok


### Instalación 🔧

1 ** Descargar los repositorios de las rutas indicadas

2 ** Importar el proyecto backedn desde la herramienta Spring tool suite 4, como existing maven project.

3 ** Abrir el proyecto de frontend desde la herramienta Spring tool suite 4, como Open projects from file system.

4 ** Desde el IDE, ubicarse en la carpeta principal del proyecto de frontend, desde una terminal local y ejecutar:

npm install -g @angular/cli@latest
npm install
npm install bootstrap

5 ** Para el proyecto de backend se requiere instalar lombok

Generalmente se realiza desde la siguiente ruta:

C:\Users\{usuario}\.m2\repository\org\projectlombok\lombok\1.18.22

Ejecutar el archivo terminado en .jar, y elegir el IDE Spring tool suite para su instalación.

Reiniciar el IDE.

## Ejecutando las pruebas BACKEND ⚙️

1 ** Desde el IDE ubicarse en el proyecto backend y en la ruta; 

src/test/java, 

2 ** Se encuentran 2 archivos: 

TestTwitter y TestUser, click derecho en cada uno y seleccionar la opción: Run as / JUnitTest

## Ejecutando las pruebas FRONTEND ⚙️

1 ** Ejecutar el proyecto de backend:

Dentro del IDE click derecho en la carpeta principal backend y seleccionar la opcion Run as / Spring boot app

2 **  Ejecutar proyecto front end

Desde el IDE, ubicarse en la carpeta principal del proyecto de frontend, desde una terminal local y ejecutar:

npm start

3 ** Abrir el explorador e ingresar a la siguiente ruta:

http://localhost:4200/#/home

Seleccionar un usuario de la lista de usuarios.

Modificar la información.  Click en SAVE.

Digitar una palabra en la caja SEARCH y enter.

** Si se desea probar el consumo de servicios de twitter desde node, ingresar a:

http://localhost:4200/#/zemogaNode

Los archivos utilizados para esta implementacion son: config.ts y server.ts


### Pruebas desde Postman - Backend 🔩

1 ** Probar servicios de portfolio:

Consultar un usuario: GET
http://localhost:8082/user/{idportfolio}

Consultar todos los usuarios: GET
http://localhost:8082/user

Actualizar información de un usuario: PUT
http://localhost:8082/user/{idportfolio}

Ejemplo Request en el Body:
{
    "idportfolio": 7,
    "description": "descripcion modificada",
    "experienceSummary": "mcallamcalla1111",
    "id": 242342,
    "imageUrl": "url",
    "lastNames": "Calla111",
    "names": "MC111",
    "tittle": "SR111",
    "twitterUserId": "1245411111",
    "twitterUserName": "user_name1Mod",
    "userId": "1111",
    "address": "",
    "email": "a@gmail.com",
    "experience": "mucha",
    "imagePath": "c://",
    "name": "Blue",
    "phone": "",
    "twitterUser": "",
    "zipCode": "",
    "title": ""
}


2 ** Probar servicios de twitter:

Consultar los 5 ultimos tweets de un usuario: GET
http://localhost:8082/user/{idportfolio}/tweets

Consultar 5 tweets según un criterio de búsqueda: GET
http://localhost:8082/user/{idportfolio}/tweets/{criterio}

## Despliegue 📦

1 ** Ejecutar el proyecto de backend:

Dentro del IDE click derecho en la carpeta principal backend y seleccionar la opcion Run as / Spring boot app

2 ** Ejecutar el proyecto de frontend

Desde el IDE, ubicarse en la carpeta principal del proyecto de frontend, desde una terminal local y ejecutar:

npm start

## Construido con 🛠�?
** Spring tool suite 4
** JDK 11
** Node.js 16.14.0
** Angular cli 11.0.4
** NPM 8.3.1
** Lombok
** Junit
** Bootstrap
** Plantilla front: https://www.creative-tim.com/product/paper-kit-2-angular

## Autores ✒️

* **Deissy Coral** - *Technical Test by Zemoga* - [deissysita](https://github.com/deissysita)

---
