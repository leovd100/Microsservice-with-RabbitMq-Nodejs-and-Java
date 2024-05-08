const { EmailTemplate } = require("../model/EmailTemplate.js");
const create = (consumerMessage) => {
  const { contactValue } = consumerMessage;
  return new EmailTemplate(contactValue, "oi");
};

module.exports = { create };
