const { EmailTemplate } = require("../model/EmailTemplate.js");
const { HtmlTemplate } = require("../model/htmlTemplate.js");
const create = (consumerMessage) => {
  const { contactValue, name } = consumerMessage;
  const subject = "Cadastro feito com sucesso!!";
  const html = HtmlTemplate(name);
  let textHtml = "Cadastro realizado com sucesso!!";
  return new EmailTemplate(contactValue, subject, html, textHtml);
};

module.exports = { create };
