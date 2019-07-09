# Respuestas

## Consideraciones

Para el propósito de estas urls, *{x}* denota a cualquier path variable *"x".*

La base de datos no se encuentra inicialmente poblada.

En caso de tener algún problema con el servidor, las mismas requests pueden hacerse en htpps://localhost:8080/api con el subfijo correspondiente.

En caso de requerir más información sobre el proyecto, puede revisarse el README.md proporcionado.

En caso de preferir el cliente Postman para realizar las request, las mismas están disponibles en el siguiente link.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/c0a9e7a7dc80bcce468b)

___

## Requests para personas físicas

- **Obtener persona física por id:**

    curl -X GET "https://tecso-rest-api.herokuapp.com/api/person/natural/{id}"

- **Todas las personas físicas:**

    curl -X GET "https://tecso-rest-api.herokuapp.com/api/person/natural/"

- **Crear una persona física:**

    curl -X POST -H 'Content-Type: application/json' -H  -d '{"firstName": "Nombre", "lastName": "Apellido", "dni": 123, "cuit": 123}' "https://tecso-rest-api.herokuapp.com/api/person/natural/"

- **Editar/crear una persona física:**

    curl -X PUT -H 'Content-Type: application/json' -d '{"firstName": "nombre", "lastName": 2019, "dni": 1234, "cuit": 12345}' "https://tecso-rest-api.herokuapp.com/api/person/natural/{id}"

- **Borrar una persona física por id:**

    curl -X DELETE "https://tecso-rest-api.herokuapp.com/api/person/natural/{id}"

___

## Requests para personas jurídicas

- **Todas las personas jurídicas:**

    curl -X GET "https://tecso-rest-api.herokuapp.com/api/person/legal/"

- **Obtener una persona jurídica por id:**

    curl -X GET "https://tecso-rest-api.herokuapp.com/api/person/legal/{id}"

- **Crear una persona jurídica:**

    curl -X POST -H 'Content-Type: application/json' -d '{"businessName": "name", "firstYearOfBusiness": 2019, "cuit": 1234236}' "https://tecso-rest-api.herokuapp.com/api/person/legal/"

- **Editar/crear una persona jurídica:**

    curl -X PUT -H 'Content-Type: application/json'  -d '{"businessName": "Razón social", "firstYearOfBusiness": 2019, "cuit": 1234}' "https://tecso-rest-api.herokuapp.com/api/person/legal/{id}"

- **Borrar una persona jurídica por id:**

    curl -X DELETE "https://tecso-rest-api.herokuapp.com/api/person/legal/{id}"
