const emailCreator = require("../component/EmailCreator.js");
const smtp = require("../component/SMTPComponent.js");
const send = (msg) => {
  const consumerMessage = JSON.parse(msg);
  const email = emailCreator.create(consumerMessage);
  smtp.sendEmail(email.email, email.subject, email.html, email.textHtml);
};

module.exports = { send };
