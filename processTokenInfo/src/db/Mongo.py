from pymongo import MongoClient
from dotenv import load_dotenv
import os

load_dotenv()


class Mongo():
    def __init__(self) -> None:
        pass

    def mongo_conect(self, token):
        if token != None:
            user = os.getenv('mongo_user')
            psw = os.getenv('mongo_password')
            host = os.getenv('mongo_host')
            database = os.getenv('mongo_database')
            coll = os.getenv('mongo_collection') 
            print("Iniciando mongo client")
            client = MongoClient(f'mongodb://{user}:{psw}@{host}/')
            db = client[database]
            collection = db[coll]
            document = token
            print("inserindo valor no mongo client")
            result = collection.insert_one(document)
            print('Documento inserido com ID:', result.inserted_id)
