# Message servie processor

This application is responsible for processing the captured messages and sending them to the queues.

### Variables:

| values                    | type    | default   | info                    |
| ------------------------- | ------- | --------- | ----------------------- |
| SERVER_PORT               | integer | 8083      | server port             |
| SMS-RABBITMQ-EXCHANGE     | string  | ---       | sms exchange            |
| SMS-RABBITMQ-ROUTINGKEY   | string  | ---       | sms routing key         |
| EMAIL-RABBITMQ-EXCHANGE   | string  | ---       | email rabbitmq exchange |
| EMAIL-RABBITMQ-ROUTINGKEY | string  | ---       | email routing key       |
| RABBIT-HOST               | string  | localhost | rabbitMq host           |
| RABBIT-PORT               | integer | 5672      | rabbitMq port           |
| RABBIT-USERNAME           | string  | ---       | rabbitMq user           |
| RABBIT-PASSWORD           | string  | ---       | rabbitMq password       |
| DATABASE-SOURCE-ULR       | string  | ---       | url JDBC                |
| DATABASE-USERNAME         | string  | ---       | postgres username       |
| DATABASE-PASSWORD         | string  | ---       | postgres password       |
| JPA-HIBERNATE-DIALECT     | string  | ---       | JPA DIALECT             |
| JPA-DLL-AUTO              | string  | update    | JPA DDL AUTO            |
