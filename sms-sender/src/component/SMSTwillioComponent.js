require("dotenv").config({ path: "./config/.env" });
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;
const client = require("twilio")(accountSid, authToken);

const sendSMS = (phone) => {
  client.messages
    .create({
      body: "Teste",
      from: "+16192686314",
      to: "+5511946334467",
    })
    .then((message) => console.log("Mensagem enviada com sucesso "));
};

module.exports = { sendSMS };
