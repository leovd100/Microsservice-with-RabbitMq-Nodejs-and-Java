const { messageCreator } = require("../component/MessageCreator.js");
const { sendToRedis } = require("./RedisService.js");
const send = (msg) => {
  //Enviar mensagem
  //Converter a mensagem para object
  const consumerMessage = JSON.parse(msg);
  const message = messageCreator(consumerMessage);
  console.log(`Sending SMS to ${message.cellPhone}...`);
  sendSMS(message);
};

module.exports = { send };
