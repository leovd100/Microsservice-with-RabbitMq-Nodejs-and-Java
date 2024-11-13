# Finger print processor

This project aims to receive the fingerPrint, process it and send it to the queue

### Variables:

| values                         | type    | default                                               | info                                          |
| ------------------------------ | ------- | ----------------------------------------------------- | --------------------------------------------- |
| DB_PASSWORD                    | string  | ---                                                   | Database password                             |
| DIALECT                        | string  | H2                                                    | Database Dialect                              |
| JDBC_URL                       | string  | jdbc:h2:mem;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE | Database Connection URL                       |
| DB_USER_NAME                   | string  | sa                                                    | Database username                             |
| DB_DRIVER                      | string  | org.h2.Driver                                         | Database JDBC Driver                          |
| DDL_AUTO                       | string  | update                                                | Schema generation configuration for Hibernate |
| OPENAPI_ENABLED                | boolean | true                                                  | Enabling OpenAPI for the application          |
| OPENAPI_CONTROLLER_ANNOTATIONS | boolean | true                                                  | Enabling Control Annotations for OpenAPI      |
| SERVER_PORT                    | int     | 8085                                                  | Micronaut Server Port                         |
| SNAKE_CASE                     | string  | ---                                                   | Naming Strategy for Jackson Properties        |
| CORS_ENABLED                   | boolean | false                                                 | Enabling CORS (optional)                      |
| TOKEN_RABBITMQ_EXCHANGE        | string  | ---                                                   | Exchange name for token in RabbitMQ           |
| TOKEN_RABBITMQ_ROUTINGKEY      | string  | ---                                                   | Routing key for the token in RabbitMQ         |
| RABBITMQ_URI                   | string  | localhost:5672                                        | RabbitMQ client address in Micronaut          |
| RABBITMQ_USER                  | string  | ---                                                   | RabbitMQ Client User on Micronaut             |
| RABBITMQ_PASSWORD              | string  | ---                                                   | RabbitMQ Client Password in Micronaut         |
