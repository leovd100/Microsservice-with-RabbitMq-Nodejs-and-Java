# SMS SERVICE

This application is responsible for processing messages received from the SMS queue and sending them to the customer.

### Variables:

| values              | type   | default   | info                                    |
| ------------------- | ------ | --------- | --------------------------------------- |
| RABBITMQ_HOST       | string | localhost | Endereço do host do RabbitMQ            |
| RABBITMQ_PORT       | int    | 5672      | Porta do RabbitMQ                       |
| QUEUE_NAME          | string | ---       | Nome da fila para SMS                   |
| USER                | string | ---       | Usuário do RabbitMQ                     |
| PASSWORD            | string | ---       | Senha do usuário RabbitMQ               |
| TWILIO_ACCOUNT_SID  | string | ---       | SID da conta Twilio                     |
| TWILIO_AUTH_TOKEN   | string | ---       | Token de autenticação Twilio            |
| TWILIO_PHONE_NUMBER | string | ---       | Número de telefone registrado no Twilio |
