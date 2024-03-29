# Tecso Spring Boot Test Problema 1

## Consideraciones

La aplicación es accesible para hacer requests en heroku desde [este link](https://tecso-rest-api.herokuapp.com/api/). Alternativamente, se puede descargar el proyecto y correrlo localmente.

Las requests requeridas se encuentran disponibles en [RESPUESTAS.MD](https://github.com/francozanini/tecso-rest-api/blob/master/RESPUESTAS.md)

La API cuenta con dos controladores. Uno para entidades jurídicas y otro para entidades físicas.

## Posibles mejoras y features a añadir

- Las responses a requests erróneas no siempre son útiles para el consumidos de la API. Es posible mejorar los mensajes devueltos en casos de excepciones o errores en la petición.

- El modelo de datos consta de dos entidades y usa herencia del tipo SINGLE-TABLE. En pos de no desperdiciar espacio, se podrían separar las entidades en distintas tablas.

- Se pueden agrupar cuestiones comunes a ambas entidades en una tercera entidad 'Titular', adaptando la API al patrón actor-rol. En este caso, se podría contar con un tercer controllador -así como servicios, dtos, etcétera- que permita realizar operaciones sobre todo tipo de persona.

- Pueden añadirse filtros, offsets y límites a los listados.

- Sería beneficioso poder buscar personas por dni o cuit y no sólo por id.

- Aún no hay pruebas unitarias.

- Para testear más la API, debería escribirse un cliente y consumir de la misma.

- Debería añadirse un servicio o un par de métodos encargados de validar input de usuario, dependiendo de qué tipos de DNI, cuit o fechas se consideren válidas.
