const emailCreator = require("../component/EmailCreator.js");
const smtp = require("../component/SMTPComponent.js");
const send = (msg) => {
  const consumerMessage = JSON.parse(msg);
  const emailTemplate = emailCreator.create(consumerMessage);
  smtp.sendEmail(emailTemplate);
  console.log("Enviando e-mail");
};

module.exports = { send };
