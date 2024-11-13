from model.TokenModel import Token 
from services.dbService import DbService

class TokenProcessor:
    def __init__(self):
        pass
        
    def save_Information(self, tokenInformation):
        token = self.generate_Object(tokenInformation)
        db = DbService()
        db.save_email(token.get_mailToken())
    
    def generate_Object(self, tokenInformation):
        return Token(tokenInformation)