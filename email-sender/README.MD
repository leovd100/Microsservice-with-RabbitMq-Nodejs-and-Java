# E-MAIL SERVICE

This project aims to consume queue information and send SMS to the end customer.

### Variables:

| values          | type    | default   | info                    |
| --------------- | ------- | --------- | ----------------------- |
| RABBITMQ_HOST   | string  | localhost | RabbitMq Host           |
| RABBITMQ_PORT   | integer | 5672      | Rabbitmq port           |
| QUEUE_NAME      | string  | ---       | Queue name for consumer |
| USER_RABBIT     | string  | guest     | User name rabbitMq      |
| PASSWORD_RABBIT | string  | guest     | Password rabbitmq       |
| USER_EMAIL      | string  | ---       | Email application       |
| PASSWORD_EMAIL  | string  | ---       | Email password          |
| HOST_EMAIL_SMTP | string  | ---       | SMTP Server             |
| PORT_SMTP       | integer | ---       | SMTP Port               |
