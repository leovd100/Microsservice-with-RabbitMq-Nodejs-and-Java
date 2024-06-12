const { messageCreator } = require("../component/MessageCreator.js");
const { sendSMS } = require("../component/SMSTwillioComponent.js");
const send = (msg) => {
  const consumerMessage = JSON.parse(msg);
  const message = messageCreator(consumerMessage);
  console.log(`Sending SMS to ${message.cellPhone}...`);
  sendSMS(message);
};

module.exports = { send };
