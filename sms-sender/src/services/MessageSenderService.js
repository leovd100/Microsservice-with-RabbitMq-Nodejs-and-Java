const { messageCreator } = require("../component/MessageCreator.js");
const { sendToRedis } = require("./RedisService.js");
const send = (msg) => {
  //Enviar mensagem
  //Converter a mensagem para object
  const consumerMessage = JSON.parse(msg);
  const message = messageCreator(consumerMessage);
<<<<<<< HEAD
  console.log(message);
  //serviço de envio para twillio
  sendToRedis(message);

  console.log("Sending SMS...");
=======
  console.log(`Sending SMS to ${message.cellPhone}...`);
  sendSMS(message);
>>>>>>> 0a8186f (twillio communication)
};

module.exports = { send };
