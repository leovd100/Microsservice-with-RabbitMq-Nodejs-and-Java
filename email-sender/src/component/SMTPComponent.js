const nodemailer = require("nodemailer");
const { sendToRedis } = require("../services/RedisService.js");
const { Contact } = require("../model/Contact.js");
require("dotenv").config({ path: "./config/.env" });

const transport = nodemailer.createTransport({
  host: `${process.env.HOST_EMAIL_SMTP}`,
  port: process.env.PORT_SMTP,
  secure: false,
  auth: {
    user: `${process.env.USER_EMAIL}`,
    pass: `${process.env.PASSWORD_EMAIL}`,
  },
  tls: { rejectUnauthorized: false },
});

const sendEmail = (emailTemplate) => {
  transport
    .sendMail({
      from: "Cadastrado com sucesso! <applicationcapturesystemnode100@outlook.com>",
      to: emailTemplate.email,
      subject: emailTemplate.subject,
      html: emailTemplate.html,
      text: emailTemplate.textHtml,
    })
    .then((response) => console.log("Email successfully sent!"))
    .catch(() => {
      console.log("Error");
      const contact = new Contact(emailTemplate.email, emailTemplate.name);
      sendToRedis(contact);
    });
};

module.exports = { sendEmail };
