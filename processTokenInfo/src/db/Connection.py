from config.config import get_connection

def start_connection():
    return get_connection()
    
def end_connection():
    connection = start_connection()
    cursor = connection.cursor()
    cursor.close()
    connection.close()

def insert_info_wp_email(uuid):
    try:
        connection = start_connection()
        cursor = connection.cursor()
        print("Connectando ao banco de dados...")
        cursor.execute("Insert into tb_group_wp_active (lead_id, entry_grupo_wp_op) values (%s,%s);", (uuid, True,))
        connection.commit()
        print("Dados atualizados com sucesso!")
    except:
        print("Erro ao atualizar as informações no banco de dados")

def find_by_email(email):
    connection = start_connection()
    cursor = connection.cursor()
    print("Connectando ao banco de dados...")
    print("Buscando e-mail")
    try:
        cursor.execute("SELECT * FROM tb_lead tl WHERE tl.email = %s", (email,))
        record = cursor.fetchone()
        print("resultado : ", record)
        if record == None:
           raise Exception("Erro: Nenhum valor encontrado na base de dados")
        else:
            return record
    except:
        print("Erro ao buscar email no banco")