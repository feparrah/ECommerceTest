# ECommerceTest
Backend test for Zara.com

Como correr la aplicacion:

Prerequisitos:
1. JDK 8+
2. Postman u otra app de prueba de APIs
3. Maven

Ejecución

Sobre la raiz del proyecto en una terminal (cmd o bash) ejecutar el comando ``mvn spring-boot:run``
Para ejecutar los test ``mvn clean test``

Ejemplo Consulta de precios:
``GET http://localhost:8080/prices/brands/1/products/35455?effectiveDate=2020-06-19T21:00:00``



