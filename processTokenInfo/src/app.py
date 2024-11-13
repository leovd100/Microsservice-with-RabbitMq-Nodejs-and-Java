from config.config import get_connection
from consumer.consumer import consumer

def main():
    try:
        print("iniciando...")
        print("▁ ▂ ▃ ▅ ▆ ▇ ▌ finger_print_processor▐ ▇ ▆ ▅ ▃ ▂ ▁")
        conn = get_connection()
        cur = conn.cursor()
        cur.execute("SELECT version();")
        record = cur.fetchone()
        print("Você está conectado ao - ", record, "\n")
        cur.close()
        conn.close()
    except:
        print("Erro ao conectar ao base de dados")

if __name__ == '__main__':
    main()
    consumer()
   