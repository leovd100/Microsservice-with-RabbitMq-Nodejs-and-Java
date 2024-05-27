const { MessageTemplate } = require("../model/MessageTemplate.js");

const messageCreator = (consumerMessage) => {
  const { contactValue } = consumerMessage;
  const message = "Olá. Você foi cadastrado com sucesso!";
  return new MessageTemplate(contactValue, message);
};

module.exports = { messageCreator };
