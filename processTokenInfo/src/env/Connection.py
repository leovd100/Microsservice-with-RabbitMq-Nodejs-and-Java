import pika
from dotenv import load_dotenv
import os

load_dotenv()

host_rabbit = os.getenv('rabbitmq_host')
port_rabbit = int(os.getenv('rabbitmq_port'))
virtual_host_rabbit = os.getenv('rabbitmq_virtual_host')
user_rabbit = os.getenv('user_rabbit')
password_rabbit = os.getenv('password_rabbit')

credentials = pika.PlainCredentials(username=user_rabbit, password=password_rabbit)
connection = pika.BlockingConnection(
    pika.ConnectionParameters(
        host=host_rabbit,
        port=port_rabbit,
        virtual_host=virtual_host_rabbit,
        credentials=credentials
    )
)
channel = connection.channel()