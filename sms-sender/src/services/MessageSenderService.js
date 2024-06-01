const { messageCreator } = require("../component/MessageCreator.js");
const { sendSMS } = require("../component/SMSTwillioComponent.js");
const { sendToRedis } = require("./RedisService.js");
const send = (msg) => {
  //Enviar mensagem
  //Converter a mensagem para object
  const consumerMessage = JSON.parse(msg);
  const message = messageCreator(consumerMessage);
  console.log(message);
  //serviço de envio para twillio
  sendToRedis(message);
  sendSMS("5511946334467");
  console.log("Sending SMS...");
};

module.exports = { send };
