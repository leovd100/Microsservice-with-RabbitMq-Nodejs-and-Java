const { MessageTemplate } = require("../model/MessageTemplate.js");

const messageCreator = (consumerMessage) => {
  const { contactValue, name } = consumerMessage;
  const message = "Olá. Você foi cadastrado com sucesso!";
  return new MessageTemplate(contactValue, message, name);
};

module.exports = { messageCreator };
