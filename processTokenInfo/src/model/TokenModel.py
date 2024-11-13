class Token():
    def __init__(self, tokenConsumer):
        self.__token = tokenConsumer["token"]
        self.__providerLocation = tokenConsumer["providerLocation"]
        self.__city = tokenConsumer["city"]
        self.__region = tokenConsumer["region"]
        self.__mailToken = tokenConsumer["mailToken"]
        self.__country = tokenConsumer["country"]
        self.__org = tokenConsumer["org"]
        self.__vpn = tokenConsumer["vpn"]
        self.__browserInfo = tokenConsumer["browserInfo"]
    
    def get_token(self):
        return self.__token
    
    def get_providerLocation(self):
        return self.__providerLocation
    
    def get_regiao(self):
        return self.__region

    def get_mailToken(self):
        return self.__mailToken   

    def get_city(self):
        return self.__city

    def get_country(self):
        return self.__country
    
    def get_org(self):
        return self.__vpn
    
    def get_browserInfo(self):
        return self.__browserInfo