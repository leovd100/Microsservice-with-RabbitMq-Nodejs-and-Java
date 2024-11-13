import json
from env import Connection
from services.TokenProcessor import TokenProcessor
from db.Mongo import Mongo
from dotenv import load_dotenv
import os
load_dotenv()


def consumer():
    queue = os.getenv('rabbitmq_queue')

    Connection.channel.queue_declare(queue=queue, durable=True)

    def callback(ch, method, properties, body):
        try:
            message = json.loads(body)
            print("Recebendo mensagem do RabbitMq")
            TokenProcessor().save_Information(message)
            Mongo().mongo_conect(message)
        except json.JSONDecodeError:
            print("Erro ao receber informações do Rabbit")


    Connection.channel.basic_consume(queue=queue, auto_ack=True, on_message_callback=callback)

    print(' [*] Waiting for messages. To exit press CTRL+C')
    Connection.channel.start_consuming()