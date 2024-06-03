require("dotenv").config({ path: "./config/.env" });
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;
const client = require("twilio")(accountSid, authToken);
const { sendToRedis } = require("../services/RedisService.js");

const sendSMS = (messageTemplate) => {
  client.messages
    .create({
      body: messageTemplate.message,
      from: process.env.TWILIO_PHONE_NUMBER,
      to: messageTemplate.cellPhone,
    })
    .then((message) => console.log("Mensagem enviada com sucesso "))
    .catch((err) => {
      console.log("Erro to send message");
      sendToRedis(messageTemplate);
    });
};

module.exports = { sendSMS };
