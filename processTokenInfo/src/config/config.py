import psycopg2
from dotenv import load_dotenv
import os
load_dotenv()

def get_connection():
    conn = psycopg2.connect(
        dbname=os.getenv('postgres_dbname'),
        user=os.getenv('postgres_user'),
        password=os.getenv('postgres_password'),
        host=os.getenv('postgres_host'), 
        port=os.getenv('postgres_port')
    )
    return conn