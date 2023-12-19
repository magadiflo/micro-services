# [Microservices tutorial with Spring boot 3](https://www.youtube.com/watch?v=KJ0cSvYj41c)

La arquitectura de microservicios que trabajaremos en este tutorial se resume en el siguiente diagrama:

![Microservices Architecture](./assets/01.microservices-architecture.png)

## Relación entre Students y Schools

![relationship](./assets/02.relationship.png)

## Estableciendo comunicación entre los dos microservicios

Luego de implementar ambos microservicios y utilizar el `RestClient` en el microservicio `schools` para comunicarnos
con el microservicio `students`, es que a continuación realizamos las pruebas para ver que estamos obtenemos los datos
de ambos microservicios, lo que significa que la comunicación se realiza de manera exitosa:

````bash
$ curl -v http://localhost:8082/api/v1/schools/with-students/2 | jq

>
< HTTP/1.1 200
< Content-Type: application/json
<
{
  "name": "RFS de Yugoslavia",
  "email": "yugoslavo@gmail.com",
  "students": [
    {
      "firstName": "Melissa",
      "lastName": "Machuca",
      "email": "Melissa@gmail.com"
    },
    {
      "firstName": "Gianfranco",
      "lastName": "Castillo",
      "email": "castillo@gmail.com"
    },
    {
      "firstName": "Lenin",
      "lastName": "Cruzado",
      "email": "lenin@gmail.com"
    },
    {
      "firstName": "Nuria",
      "lastName": "Ponce",
      "email": "nuria@gmail.com"
    }
  ]
}
````