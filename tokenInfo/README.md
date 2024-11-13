| values                         | type    | default                                               | info                                              |
| ------------------------------ | ------- | ----------------------------------------------------- | ------------------------------------------------- |
| DB_PASSWORD                    | string  | ---                                                   | Senha do banco de dados                           |
| DIALECT                        | string  | H2                                                    | Dialeto do banco de dados                         |
| JDBC_URL                       | string  | jdbc:h2:mem;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE | URL de conexão do banco de dados                  |
| DB_USER_NAME                   | string  | sa                                                    | Nome de usuário do banco de dados                 |
| DB_DRIVER                      | string  | org.h2.Driver                                         | Driver JDBC do banco de dados                     |
| DDL_AUTO                       | string  | update                                                | Configuração de geração de esquema para Hibernate |
| OPENAPI_ENABLED                | boolean | true                                                  | Ativação do OpenAPI para a aplicação              |
| OPENAPI_CONTROLLER_ANNOTATIONS | boolean | true                                                  | Ativação das anotações de controle para o OpenAPI |
| SERVER_PORT                    | int     | 8085                                                  | Porta do servidor Micronaut                       |
| SNAKE_CASE                     | string  | ---                                                   | Estratégia de nomeação para propriedades Jackson  |
| CORS_ENABLED                   | boolean | false                                                 | Ativação do CORS (opcional)                       |
| TOKEN_RABBITMQ_EXCHANGE        | string  | ---                                                   | Nome da exchange para o token no RabbitMQ         |
| TOKEN_RABBITMQ_ROUTINGKEY      | string  | ---                                                   | Routing key para o token no RabbitMQ              |
| RABBITMQ_URI                   | string  | localhost:5672                                        | Endereço do cliente RabbitMQ no Micronaut         |
| RABBITMQ_USER                  | string  | ---                                                   | Usuário do cliente RabbitMQ no Micronaut          |
| RABBITMQ_PASSWORD              | string  | ---                                                   | Senha do cliente RabbitMQ no Micronaut            |
