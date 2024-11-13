# Process Token Service

This application is responsible for processing messages received from the fingerPrint queue.

### Variables:

| values                | type   | default          | info                               |
| --------------------- | ------ | ---------------- | ---------------------------------- |
| mongo_database        | string | ---              | Nome do banco de dados Mongo       |
| mongo_collection      | string | ---              | Nome da coleção Mongo              |
| mongo_user            | string | ---              | Usuário do Mongo                   |
| mongo_password        | string | ---              | Senha do usuário Mongo             |
| mongo_host            | string | localhost:27017/ | Endereço do host do Mongo          |
| postgres_dbname       | string | ---              | Nome do banco de dados Postgres    |
| postgres_user         | string | ---              | Usuário do banco de dados Postgres |
| postgres_password     | string | ---              | Senha do usuário Postgres          |
| postgres_host         | string | localhost        | Endereço do host do Postgres       |
| postgres_port         | int    | 5432             | Porta do Postgres                  |
| rabbitmq_host         | string | localhost        | Endereço do host do RabbitMQ       |
| rabbitmq_port         | int    | 5672             | Porta do RabbitMQ                  |
| rabbitmq_virtual_host | string | /                | Virtual host do RabbitMQ           |
| rabbitmq_queue        | string | ---              | Nome da fila do RabbitMQ           |
| user_rabbit           | string | ---              | Usuário do RabbitMQ                |
| password_rabbit       | string | ---              | Senha do usuário RabbitMQ          |
