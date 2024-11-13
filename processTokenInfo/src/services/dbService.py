from db import Connection
class DbService:
    def __init__(self):
        self.conn = Connection
  
    def check_email_exist(self,email):
        try:
            return self.conn.find_by_email(email)
        except:
            print("Houve um erro interno na busca por email")

    def save_email(self, email):
        db_search = self.check_email_exist(email)
        if db_search != None:
            self.conn.insert_info_wp_email(db_search[0])
        else:
            print("DB_SEARCH IS NONE")